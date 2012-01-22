package se.miun.swot.nfc;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

/* XML handler to parse a specific XML layout
* 
* <bottles>
* 		<bottle>
* 			<id> </id>
* 			<temp> </temp>
* 		</bottle>
* 		...
* </bottles>
* 
* eventually populates a ArrayList<ArrayList<String>> with all the ids and the temperatures
* of all the bottles, accessible with getBottles()
* 
*/
public class SWoT_NFC_XMLHandler extends DefaultHandler{

	private int i = 0;
	private boolean parseBottle = false;
	private boolean storeBottle = false;
	private boolean newBottle = false;
	
	private ArrayList<ArrayList<String>> bottles = new ArrayList<ArrayList<String>>();
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if(i == 0 && localName.equalsIgnoreCase("bottles")){
			parseBottle = true;
			Log.i("BOTTLES", "parse bottles");
			i++;
		}
		
		if(parseBottle){
			if(localName.equalsIgnoreCase("bottle")){
				newBottle = true;
				Log.i("B", "new bottle");
			}
			else if(localName.equalsIgnoreCase("id")){
				storeBottle = true;
				Log.i("B", "new bottle");
			}
		}
	}
		
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(localName.equalsIgnoreCase("bottle")){
			if(parseBottle){
				bottles.add(bottle);
				Log.i("NEW BOTTLE", bottle.toString());
				bottle = null;
			}
		} 
	}
	
	ArrayList<String> bottle = null;
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		
		if(newBottle){
			bottle = new ArrayList<String>();
			newBottle = false;
		}
		
		if(storeBottle){
			String data = new String(ch, start, length);
			bottle.add(data);
			Log.i("CHAR", data);
		}	
	}
	
	public ArrayList<ArrayList<String>> getBottles(){
		return bottles;
	}
}
