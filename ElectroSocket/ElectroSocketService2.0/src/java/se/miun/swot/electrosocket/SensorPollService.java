/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.swot.electrosocket;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author JohnDoe
 */
@WebService(serviceName = "SensorPollService")
public class SensorPollService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getSWOTApplicationName")
    public String getSWOTApplicationName() {
        return "Jackie Chanelle";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getTemperature")
    public int getTemperature() {
        if (LocalCOMPoller.zig == null) return -1234;
        return LocalCOMPoller.zig.getTemperature();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getHumidity")
    public int getHumidity() {
        if (LocalCOMPoller.zig == null) return -1234;
        return LocalCOMPoller.zig.getHumidity();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOnLight")
    public boolean getOnLight() {
        if (LocalCOMPoller.zig == null) return false;
        return LocalCOMPoller.zig.isOnLight();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOnSocket")
    public boolean getOnSocket() {
        if (LocalCOMPoller.zig == null) return false;
        return LocalCOMPoller.zig.isOnSocket();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "setOnLight")
    public void setOnLight(@WebParam(name = "state") boolean state) {
        if (LocalCOMPoller.zig == null) return;
        
        LocalCOMPoller.zig.setOnLight(state);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "setOnSocket")
    public void setOnSocket(@WebParam(name = "state") boolean state) {
        if (LocalCOMPoller.zig == null) return;
        
        LocalCOMPoller.zig.setOnSocket(state);
    }
}
