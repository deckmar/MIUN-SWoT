package se.miun.swot.nfc;

import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class SWoT_NFC_Display extends ListActivity implements OnClickListener {

	private String REST_URL = "http://" + SWoT_NFC_Detector.SERVER
			+ ":8080/NFC_REST_Server/resources/tags";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//set up of the GUI
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setGravity(Gravity.RIGHT);
		// one button for update purposes
		Button button = new Button(this);
		button.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		button.setText("Update");
		button.setOnClickListener(this);
		// a ListView to display all the bottles information
		ListView list = new ListView(this);
		list.setId(android.R.id.list);
		
		layout.addView(button);
		layout.addView(list);
		setContentView(layout);
		
		// call async task
		new RetrieveRestDataTask().execute();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		new RetrieveRestDataTask().execute();
	}
	
	// async task with the responsibility to execute a HTTP GET call to the RESTful web service
	// to fetch all the bottles information and then populate the ListView
	class RetrieveRestDataTask extends AsyncTask<Void, Void, ArrayList<ArrayList<String>>>{

		@Override
		protected ArrayList<ArrayList<String>> doInBackground(Void... arg0) {
			Log.i("DIB", "Retrieving data from REST Server...");
			try{
				// create URL to stream the URL address subsequently
				URL website = new URL(REST_URL);
				// set up of a SAX environment for XML parsing
		    	SAXParserFactory factory = SAXParserFactory.newInstance();
		    	SAXParser parser = factory.newSAXParser();
		    	XMLReader reader = parser.getXMLReader();
		    	// create customize XML handler
		    	SWoT_NFC_XMLHandler handler = new SWoT_NFC_XMLHandler();
		    	reader.setContentHandler(handler);
		    	// open the stream and parse the XML output
		    	reader.parse(new InputSource(website.openStream()));
		    	
		    	// return a ArrayList<ArrayList<String>> for the onPostExecute method
		    	return handler.getBottles();
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}

		// set customized ArrayListAdapter for the ListAdapter
		// this will populate the ListView with all the bottles information
		@Override
		protected void onPostExecute(ArrayList<ArrayList<String>> result) {
			super.onPostExecute(result);
	    	setListAdapter(new ArrayListAdapterForBottles(getApplicationContext(), result));
			Log.i("OPE", result.toString());
		}
	}

	@Override
	public void onClick(View arg0) {
		new RetrieveRestDataTask().execute();
	}
	
}
