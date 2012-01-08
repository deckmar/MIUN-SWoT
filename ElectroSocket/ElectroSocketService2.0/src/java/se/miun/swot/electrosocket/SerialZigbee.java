package se.miun.swot.electrosocket;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author Stefan Forsström
 *
 * Requires: RXTXcomm.jar in Libraries and rxtxSerial.dll in
 * c:\Windows\System32\ or librxtxSerial.so in Linux
 *
 *
 */
public class SerialZigbee {

    public SerialPort serialPort;
    private InputStream in;
    private OutputStream out;
    private int temperature = -1;
    private int humidity = -1;
    private int power_socket = -1;
    private int power_light = -1;
    private boolean on_socket = false;
    private boolean on_light = false;


    public SerialZigbee(String portName) {
        try {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);


            CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

            serialPort = (SerialPort) commPort;
            serialPort.setSerialPortParams(19200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

            in = serialPort.getInputStream();
            out = serialPort.getOutputStream();

        } catch (Exception e) {
            System.out.println("[SerialZigbee] Fatal startup error");
            e.printStackTrace();
        }

    }

    public void pollSensors() {
        try {
            String get = "GET /\n";
            out.write(get.getBytes());
            out.flush();

            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(reader);

            String line = "";
            String waitFor = "HTTP/1.1 200 OK";
            while ((line = br.readLine()) != null && !line.contains(waitFor)) {
                //System.out.println("Waiting for '" + waitFor + "', got: " + line);
            }

            waitFor = "Temperature=";
            while ((line = br.readLine()) != null && !line.contains(waitFor)) {
                //System.out.println("Waiting for '" + waitFor + "', got: " + line);
            }

            temperature = Integer.parseInt(line.split("=")[1]);
            int calibration = -11;
            temperature += calibration;
            line = br.readLine();
            line = br.readLine();

            humidity = Integer.parseInt(line.split("=")[1]);
            line = br.readLine();
            line = br.readLine();

            power_socket = Integer.parseInt(line.split("=")[1]);
            line = br.readLine();
            line = br.readLine();

            power_light = Integer.parseInt(line.split("=")[1]);
            line = br.readLine();
            line = br.readLine();
            
            on_light = (line.split("=")[1].equals("1"));
            line = br.readLine();
            line = br.readLine();

            on_socket = (line.split("=")[1].equals("1"));
            line = br.readLine();
            line = br.readLine();
            

//            System.out.println("temperature = " + this.temperature);
//            System.out.println("humidity = " + this.humidity);
//            System.out.println("power_socket = " + this.power_socket);
//            System.out.println("power_light = " + this.power_light);
//            System.out.println("on_light = " + this.on_light);
//            System.out.println("on_socket = " + this.on_socket);

        } catch (Exception e) {
            System.out.println("[PollSensors] Error");
        }
    }

    public void turnOn1() {
        try {

            String on = "n1\n";
            out.write(on.getBytes());
            out.flush();

        } catch (Exception e) {
            System.out.println("[TurnOn] Error");
        }
    }

    public void turnOff1() {
        try {

            String off = "f1\n";
            out.write(off.getBytes());
            out.flush();

        } catch (Exception e) {
            System.out.println("[TurnOff] Error");
        }
    }

    public void turnOn2() {
        try {

            String on = "n2\n";
            out.write(on.getBytes());
            out.flush();

        } catch (Exception e) {
            System.out.println("[TurnOn] Error");
        }
    }

    public void turnOff2() {
        try {

            String off = "f2\n";
            out.write(off.getBytes());
            out.flush();

        } catch (Exception e) {
            System.out.println("[TurnOff] Error");
        }
    }

    public void turnOn3() {
        try {

            String on = "n3\n";
            out.write(on.getBytes());
            out.flush();

        } catch (Exception e) {
            System.out.println("[TurnOn] Error");
        }
    }

    public void turnOff3() {
        try {

            String off = "f3\n";
            out.write(off.getBytes());
            out.flush();

        } catch (Exception e) {
            System.out.println("[TurnOff] Error");
        }
    }

    public void turnOn4() {
        try {

            String on = "n4\n";
            out.write(on.getBytes());
            out.flush();

        } catch (Exception e) {
            System.out.println("[TurnOn] Error");
        }
    }

    public void turnOff4() {
        try {

            String off = "f4\n";
            out.write(off.getBytes());
            out.flush();

        } catch (Exception e) {
            System.out.println("[TurnOff] Error");
        }
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public boolean isOnSocket() {
        return on_socket;
    }
    
    public boolean isOnLight() {
        return on_light;
    }

    public void setOnLight(boolean on_light) {
        if (on_light) {
            this.turnOn2();
        } else {
            this.turnOff2();
        }
        this.on_light = on_light;
    }

    public void setOnSocket(boolean on_socket) {
        if (on_socket) {
            this.turnOn3();
        } else {
            this.turnOff3();
        }
        this.on_socket = on_socket;
    }

    public int getPower_light() {
        return power_light;
    }

    public void setPower_light(int power_light) {
        this.power_light = power_light;
    }

    public int getPower_socket() {
        return power_socket;
    }

    public void setPower_socket(int power_socket) {
        this.power_socket = power_socket;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
