/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.swot.electrosocket;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author JohnDoe
 */
public class LocalCOMPoller implements ServletContextListener, Runnable {

    public static int secretValue = 0;
    public static final int CONF_SENSOR_POLL_INTERVAL_MS = 5000;
    public static boolean RUNNING = true;
    public static SerialZigbee zig = null;

    // Poll the sensor at intervals
    public void run() {
        while (RUNNING) {

            if (zig != null) {
                System.out.println("Polling values");
                zig.pollSensors();

                System.out.println("Temp = " + zig.getTemperature());
            }


            try {
                Thread.sleep(CONF_SENSOR_POLL_INTERVAL_MS);
            } catch (InterruptedException ex) {
                Logger.getLogger(LocalCOMPoller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // Initialize
        //System.loadLibrary("rxtxSerial.dll");
        
        System.out.println("Path = " + new File("").getAbsolutePath());
        
        zig = new SerialZigbee("COM4");
        System.out.println("Hello world :-)");
        LocalCOMPoller.secretValue = 42;

        // Run pull loop in new thread
        Executors.newSingleThreadExecutor().submit(this);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
