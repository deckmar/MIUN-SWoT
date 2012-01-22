package se.miun.swot.nfc;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SWoT_NFC_Simulator extends Activity implements OnClickListener {
	
	private String REST_URL = "http://" + SWoT_NFC_Detector.SERVER
			+ ":8080/NFC_REST_Server/resources/tags";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// set up of the GUI
		LinearLayout layout = new LinearLayout(this);
		
		// two Buttons for each fake tags with their fake ids
		Button but1 = new Button(this);
		but1.setText("Fake tag: 421DFT92");
		but1.setOnClickListener(this);
		but1.setId(1001);
		Button but2 = new Button(this);
		but2.setText("Fake tag: 811ANKES");
		but2.setOnClickListener(this);
		but2.setId(1002);
		
		layout.setGravity(Gravity.CENTER_HORIZONTAL);
		layout.addView(but1);
		layout.addView(but2);
		
		setContentView(layout);
	}

	// call an async task when one of the button is clicked
	@Override
	public void onClick(View view) {
		switch(view.getId()){
		case 1001:
			new SendBottleDataToREST().execute("421DFT92");
			break;
		case 1002:
			new SendBottleDataToREST().execute("811ANKES");
			break;
		}
	}
	
	// async task with the responsibility to execute a HTTP PUT call to the RESTful web service
		// to push the id and the temperature of the Tag
	class SendBottleDataToREST extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... param) {
			Log.i("SIM", "Sending data to REST Server...");
			
			// set up for HTTP PUT call
			HttpClient httpclient = new DefaultHttpClient();
	        HttpResponse response;
	        try {
	        	// assign the REST address
				HttpPut httpPut = new HttpPut(REST_URL);
				// specify the right content type, XML in our case
				httpPut.addHeader("Content-Type", "application/xml");
				// create an XML entity with the id and the temperature generated 
				// thanks to the getTemp method
				HttpEntity entity = new StringEntity("<bottle>" + "<id>"
						+ param[0] + "</id>" + "<temp>" + getTemp() + "</temp>"
						+ "</bottle>");
				// assign entity to HttpPut
				httpPut.setEntity(entity);
				// execute the HTTP PUT call
				response = httpclient.execute(httpPut);
				// close the communication
				response.getEntity().getContent().close();
				
				// return String to the onPostExecute method
	            return "Data sent";
	        } catch (ClientProtocolException e) {
	            e.printStackTrace();
	            return "ClientProtocolException";
	        } catch (IOException e) {
	        	e.printStackTrace();
	            return "IOException";
	        }
		}
	
		// display a temporary message to the user 
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
		}
		
		// generate a random value between 8 and 15 and returns it as a String
		private String getTemp() {
			int temp = (int)(Math.random()*8) + 8;
			return ""+temp;
		}
	}
	
}
