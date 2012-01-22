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
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SWoT_NFC_Detector extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	
	private TextView id;
	private TextView temperature;
	// here put the IP address where the RESTful web service is running
	public static final String SERVER = "79.136.36.225"; 
	// here is the whole RESTful address
	private String REST_URL = "http://" + SERVER
			+ ":8080/NFC_REST_Server/resources/tags";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// set some default text for both TextViews
		id = (TextView) findViewById(R.id.id);
		id.setText("Wait...");
		temperature = (TextView) findViewById(R.id.temp);
		temperature.setText("0 degrees Celsius");

		// set OnClickListener on the Button
		Button button = (Button) findViewById(R.id.but_databse);
		button.setOnClickListener(this);

		detectNfc(getIntent());
	}

	// this method checks if the Intent that triggered the activity corresponds to
	// a NfcAdapter.ACTION_TAG_DISCOVERED action and if so fetches the Tag from the extras
	// and finally calls the sendNFCDataToRESTServer method with it
	private void detectNfc(Intent intent) {
		if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {
			Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
			// if tag is discovered (when using the phone)
			if (tag != null)
				sendNFCDataToRESTServer(tag);
			// if an error occurs
			else {
				id.setText("Error...");
				temperature.setText("Error...");
				Toast.makeText(getApplicationContext(),
						"Error. Please scan the tag again.", Toast.LENGTH_SHORT)
						.show();
			}
		} else {
			Log.e("RFID", "NO RFID INTENT " + intent);
			finish();
			return;
		}

	}

	// this method gets the id of the Tag argument and then calls an asynchronous task 
	// with the class SendBottleDataToREST
	private void sendNFCDataToRESTServer(Tag someTag) {
		if (someTag == null)
			id.setText("No tag");
		else {
			// the id is in bytes and needs to be converted to a String thanks to 
			// the method toHexString
			String _id = toHexString(someTag.getId());
			try {
				id.setText(_id);
				new SendBottleDataToREST().execute(_id); // call async task
			} catch (Exception e) {
				Log.i("EXCPT", "UNSUPPORTED ENCODING EXCEPTION");
				throw new RuntimeException("UNSUPPORTED ENCODING EXCEPTION");
			}
		}
	}

	// async task with the responsibility to execute a HTTP PUT call to the RESTful web service
	// to push the id and the temperature of the Tag
	class SendBottleDataToREST extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... param) {
			Log.i("NFC", "Sending data to REST Server...");

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
			Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT)
					.show();
		}
	}

	// generate a random value between 8 and 15 and returns it as a String
	// and set the text of the temperature's textView to the new value
	private String getTemp() {
		final int temp = (int) (Math.random() * 8) + 8;
		SWoT_NFC_Detector.this.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				temperature.setText(temp + "ºC");
			}
		});
		return "" + temp;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		detectNfc(getIntent());
	}

	@Override
	protected void onPause() {
		super.onPause();
		id.setText("Paused...");
		temperature.setText("...");
	}

	// convert bytes to String
	public static String toHexString(byte[] bytes) {
		char[] hexArray = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		char[] hexChars = new char[bytes.length * 2];
		int v;
		for (int j = 0; j < bytes.length; j++) {
			v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v / 16];
			hexChars[j * 2 + 1] = hexArray[v % 16];
		}
		return new String(hexChars);
	}

	// direct to the SWoT_NFC_TabHost Activity
	@Override
	public void onClick(View view) {
		startActivity(new Intent(getApplicationContext(),
				SWoT_NFC_TabHost.class));
	}

}