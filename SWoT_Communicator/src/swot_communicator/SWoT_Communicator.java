/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swot_communicator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.System;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 *
 * @author alexandre
 */
public class SWoT_Communicator {

    private final static String SERVER = "localhost";
    private final static String REST_URL = "http://"+SERVER+":8080/NFC_REST_Server/resources/nfcSwotTemp";;
    
    public static void main(String[] args) {
        start();
    }
    
    private static void start() {
        System.out.println("\n------------- SWoT Communicator --------------\n"
                        + "-Whisky Bottle (press 1)\n"
                        + "-Electrical Socket (press 2)\n\n"
                        + ".......\n"
                        + "  Quit (press 3)\n"
                        + ".......\n");
        boolean choice = true;
        while(choice){
            Scanner s = new Scanner(System.in);
            while(!s.hasNextInt()){
                System.out.println("\nEnter a correct key. Please try again.\n");
                s.next();
            }
            switch(s.nextInt()){
                case 1:
                    whiskyBottle();
                    choice = false;
                    break;
                case 2:
                    electroSocket();
                    choice = false;
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nEnter a correct key. Please try again.\n");
                    break;
            }
        }
    }

    private static void electroSocket() {
        System.out.println("\n------------- Electrical Socket --------------\n"
                        + "-Temperature (press 1)\n"
                        + "-Humidity (press 2)\n"
                        + "-Turn on/off lamp (press 3)\n"
                        + "-Turn on/off fan (press 4)\n\n"
                        + ".......\n"
                        + "  Go back (press 5)\n"
                        + ".......\n");
        boolean socketChoice = true;
        while(socketChoice){
            Scanner s = new Scanner(System.in);
            while(!s.hasNextInt()){
                System.out.println("\nEnter a correct key. Please try again.\n");
                s.next();
            }
            switch(s.nextInt()){
                case 1:
                    System.out.println("\nThe socket temperature is "+getTemperature()+" degrees Celsius.");
                    socketChoice = false;
                    break;
                case 2:
                    System.out.println("\nThe socket humidity is "+getHumidity()+"%.");
                    socketChoice = false;
                    break;
                case 3:
                    turnLamp();
                    socketChoice = false;
                    break;
                case 4:
                    turnFan();;
                    socketChoice = false;
                    break;
                case 5:
                    start();
                    socketChoice = false;
                    break;
                default:
                    System.out.println("\nEnter a correct key. Please try again.");
                    break;
            }
        }
        electroSocket();
    }

    private static void whiskyBottle() {
        System.out.println("\n------------- Whisky Bottle --------------\n"
                        + "-Bottles Temperature (press 1)\n\n"
                        + ".......\n"
                        + "  Go back (press 2)\n"
                        + ".......\n");
        boolean bottleChoice = true;
        while(bottleChoice){
            Scanner s = new Scanner(System.in);
            while(!s.hasNextInt()){
                System.out.println("\nEnter a correct key. Please try again.\n");
                s.next();
            }
            switch(s.nextInt()){
                case 1:
                    getBottlesTemperature();
                    bottleChoice = false;
                    break;
                case 2:
                    start();
                    bottleChoice = false;
                    break;
                default:
                    System.out.println("\nEnter a correct key. Please try again.");
                    break;
            }
        }
        whiskyBottle();
    }

    private static void getBottlesTemperature(){
        try{
            URL website = new URL(REST_URL);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            XMLHandler handler = new XMLHandler();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(website.openStream()));

//            URLConnection yc = website.openConnection();
//            BufferedReader in = new BufferedReader(
//                                    new InputStreamReader(
//                                    yc.getInputStream()));
//            String inputLine;
//            StringBuilder sb = new StringBuilder();
//            while ((inputLine = in.readLine()) != null) 
//                sb.append(inputLine+"\n");
//            in.close();
//            System.out.println(sb.toString());
                         
            System.out.print("\n"+handler.getBottles());
        } catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    private static void turnLamp() {
        checkLamp();
        
        System.out.println("\n------------- Lamp --------------\n"
                        + "-On (press 1)\n"
                        + "-Off (press 2)\n\n"
                        + ".......\n"
                        + "  Go back (press 3)\n"
                        + ".......\n");
        boolean lampChoice = true;
        while(lampChoice){
            Scanner s = new Scanner(System.in);
            while(!s.hasNextInt()){
                System.out.println("\nEnter a correct key. Please try again.\n");
                s.next();
            }
            switch(s.nextInt()){
                case 1:
                    setOnLight(true);
                    lampChoice = false;
                    break;
                case 2:
                    setOnLight(false);
                    lampChoice = false;
                    break;
                case 3:
                    electroSocket();
                    lampChoice = false;
                    break;
                default:
                    System.out.println("\nEnter a correct key. Please try again.");
                    break;
            }
        }
        turnLamp();
    }
    
    private static void checkLamp(){
        if(getOnLight())
            System.out.println("\nThe lamp is on.");
        else
            System.out.println("\nThe lamp is off.");
    }

    private static void turnFan() {
        checkFan();
        
        System.out.println("\n------------- Fan --------------\n"
                        + "-On (press 1)\n"
                        + "-Off (press 2)\n\n"
                        + ".......\n"
                        + "  Go back (press 3)\n"
                        + ".......\n");
        boolean fanChoice = true;
        while(fanChoice){
            Scanner s = new Scanner(System.in);
            while(!s.hasNextInt()){
                System.out.println("\nEnter a correct key. Please try again.\n");
                s.next();
            }
            switch(s.nextInt()){
                case 1:
                    setOnSocket(true);
                    fanChoice = false;
                    break;
                case 2:
                    setOnSocket(false);
                    fanChoice = false;
                    break;
                case 3:
                    electroSocket();
                    fanChoice = false;
                    break;
                default:
                    System.out.println("Enter a correct key. Please try again.\n");
                    break;
            }
        }
        turnFan();
    }
    
    private static void checkFan(){
        if(getOnSocket())
            System.out.println("\nThe fan is on.");
        else
            System.out.println("\nThe fan is off.");
    }

    private static int getTemperature() {
        se.miun.swot.electrosocket.SensorPollService_Service service = new se.miun.swot.electrosocket.SensorPollService_Service();
        se.miun.swot.electrosocket.SensorPollService port = service.getSensorPollServicePort();
        return port.getTemperature();
    }

    private static int getHumidity() {
        se.miun.swot.electrosocket.SensorPollService_Service service = new se.miun.swot.electrosocket.SensorPollService_Service();
        se.miun.swot.electrosocket.SensorPollService port = service.getSensorPollServicePort();
        return port.getHumidity();
    }

    private static void setOnLight(boolean state) {
        se.miun.swot.electrosocket.SensorPollService_Service service = new se.miun.swot.electrosocket.SensorPollService_Service();
        se.miun.swot.electrosocket.SensorPollService port = service.getSensorPollServicePort();
        port.setOnLight(state);
    }

    private static void setOnSocket(boolean state) {
        se.miun.swot.electrosocket.SensorPollService_Service service = new se.miun.swot.electrosocket.SensorPollService_Service();
        se.miun.swot.electrosocket.SensorPollService port = service.getSensorPollServicePort();
        port.setOnSocket(state);
    }

    private static boolean getOnLight() {
        se.miun.swot.electrosocket.SensorPollService_Service service = new se.miun.swot.electrosocket.SensorPollService_Service();
        se.miun.swot.electrosocket.SensorPollService port = service.getSensorPollServicePort();
        return port.getOnLight();
    }

    private static boolean getOnSocket() {
        se.miun.swot.electrosocket.SensorPollService_Service service = new se.miun.swot.electrosocket.SensorPollService_Service();
        se.miun.swot.electrosocket.SensorPollService port = service.getSensorPollServicePort();
        return port.getOnSocket();
    }

}
