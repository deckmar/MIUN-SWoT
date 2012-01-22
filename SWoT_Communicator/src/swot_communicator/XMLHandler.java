/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swot_communicator;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHandler extends DefaultHandler {

    private int i = 0;
    private boolean parseBottle = false;
    private boolean storeBottle = false;
    private boolean newBottle = false;
    private ArrayList<ArrayList<String>> bottles = new ArrayList<ArrayList<String>>();

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        if (i == 0 && qName.equalsIgnoreCase("bottles")) {
            parseBottle = true;
            i++;
        }

        if (parseBottle) {
            if (qName.equalsIgnoreCase("bottle")) {
                newBottle = true;
            } else if (qName.equalsIgnoreCase("id")) {
                storeBottle = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("bottle")) {
            if (parseBottle) {
                bottles.add(bottle);
                bottle = null;
            }
        }
    }
    ArrayList<String> bottle = null;

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (newBottle) {
            bottle = new ArrayList<String>();
            newBottle = false;
        }

        if (storeBottle) {
            String data = new String(ch, start, length);
            bottle.add(data);
        }
    }

    public String getBottles() {
        StringBuilder sb = new StringBuilder();
        for(ArrayList<String> bottle: bottles){
            sb.append(bottle.get(0)+" - "+bottle.get(1)+" degrees Celsius\n");
        }
        return sb.toString();
    }
}
