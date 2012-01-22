
package se.miun.swot.electrosocket;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SensorPollService", targetNamespace = "http://electrosocket.swot.miun.se/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SensorPollService {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSWOTApplicationName", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.GetSWOTApplicationName")
    @ResponseWrapper(localName = "getSWOTApplicationNameResponse", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.GetSWOTApplicationNameResponse")
    @Action(input = "http://electrosocket.swot.miun.se/SensorPollService/getSWOTApplicationNameRequest", output = "http://electrosocket.swot.miun.se/SensorPollService/getSWOTApplicationNameResponse")
    public String getSWOTApplicationName();

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTemperature", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.GetTemperature")
    @ResponseWrapper(localName = "getTemperatureResponse", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.GetTemperatureResponse")
    @Action(input = "http://electrosocket.swot.miun.se/SensorPollService/getTemperatureRequest", output = "http://electrosocket.swot.miun.se/SensorPollService/getTemperatureResponse")
    public int getTemperature();

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHumidity", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.GetHumidity")
    @ResponseWrapper(localName = "getHumidityResponse", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.GetHumidityResponse")
    @Action(input = "http://electrosocket.swot.miun.se/SensorPollService/getHumidityRequest", output = "http://electrosocket.swot.miun.se/SensorPollService/getHumidityResponse")
    public int getHumidity();

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOnLight", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.GetOnLight")
    @ResponseWrapper(localName = "getOnLightResponse", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.GetOnLightResponse")
    @Action(input = "http://electrosocket.swot.miun.se/SensorPollService/getOnLightRequest", output = "http://electrosocket.swot.miun.se/SensorPollService/getOnLightResponse")
    public boolean getOnLight();

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOnSocket", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.GetOnSocket")
    @ResponseWrapper(localName = "getOnSocketResponse", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.GetOnSocketResponse")
    @Action(input = "http://electrosocket.swot.miun.se/SensorPollService/getOnSocketRequest", output = "http://electrosocket.swot.miun.se/SensorPollService/getOnSocketResponse")
    public boolean getOnSocket();

    /**
     * 
     * @param state
     */
    @WebMethod
    @RequestWrapper(localName = "setOnLight", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.SetOnLight")
    @ResponseWrapper(localName = "setOnLightResponse", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.SetOnLightResponse")
    @Action(input = "http://electrosocket.swot.miun.se/SensorPollService/setOnLightRequest", output = "http://electrosocket.swot.miun.se/SensorPollService/setOnLightResponse")
    public void setOnLight(
        @WebParam(name = "state", targetNamespace = "")
        boolean state);

    /**
     * 
     * @param state
     */
    @WebMethod
    @RequestWrapper(localName = "setOnSocket", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.SetOnSocket")
    @ResponseWrapper(localName = "setOnSocketResponse", targetNamespace = "http://electrosocket.swot.miun.se/", className = "se.miun.swot.electrosocket.SetOnSocketResponse")
    @Action(input = "http://electrosocket.swot.miun.se/SensorPollService/setOnSocketRequest", output = "http://electrosocket.swot.miun.se/SensorPollService/setOnSocketResponse")
    public void setOnSocket(
        @WebParam(name = "state", targetNamespace = "")
        boolean state);

}
