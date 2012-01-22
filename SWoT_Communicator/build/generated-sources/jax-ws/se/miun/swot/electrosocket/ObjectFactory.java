
package se.miun.swot.electrosocket;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the se.miun.swot.electrosocket package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetSWOTApplicationNameResponse_QNAME = new QName("http://electrosocket.swot.miun.se/", "getSWOTApplicationNameResponse");
    private final static QName _GetTemperature_QNAME = new QName("http://electrosocket.swot.miun.se/", "getTemperature");
    private final static QName _GetOnSocketResponse_QNAME = new QName("http://electrosocket.swot.miun.se/", "getOnSocketResponse");
    private final static QName _GetHumidity_QNAME = new QName("http://electrosocket.swot.miun.se/", "getHumidity");
    private final static QName _GetOnLightResponse_QNAME = new QName("http://electrosocket.swot.miun.se/", "getOnLightResponse");
    private final static QName _SetOnSocket_QNAME = new QName("http://electrosocket.swot.miun.se/", "setOnSocket");
    private final static QName _SetOnLight_QNAME = new QName("http://electrosocket.swot.miun.se/", "setOnLight");
    private final static QName _SetOnSocketResponse_QNAME = new QName("http://electrosocket.swot.miun.se/", "setOnSocketResponse");
    private final static QName _GetHumidityResponse_QNAME = new QName("http://electrosocket.swot.miun.se/", "getHumidityResponse");
    private final static QName _SetOnLightResponse_QNAME = new QName("http://electrosocket.swot.miun.se/", "setOnLightResponse");
    private final static QName _GetOnSocket_QNAME = new QName("http://electrosocket.swot.miun.se/", "getOnSocket");
    private final static QName _GetOnLight_QNAME = new QName("http://electrosocket.swot.miun.se/", "getOnLight");
    private final static QName _GetSWOTApplicationName_QNAME = new QName("http://electrosocket.swot.miun.se/", "getSWOTApplicationName");
    private final static QName _GetTemperatureResponse_QNAME = new QName("http://electrosocket.swot.miun.se/", "getTemperatureResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: se.miun.swot.electrosocket
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSWOTApplicationNameResponse }
     * 
     */
    public GetSWOTApplicationNameResponse createGetSWOTApplicationNameResponse() {
        return new GetSWOTApplicationNameResponse();
    }

    /**
     * Create an instance of {@link GetOnLight }
     * 
     */
    public GetOnLight createGetOnLight() {
        return new GetOnLight();
    }

    /**
     * Create an instance of {@link GetSWOTApplicationName }
     * 
     */
    public GetSWOTApplicationName createGetSWOTApplicationName() {
        return new GetSWOTApplicationName();
    }

    /**
     * Create an instance of {@link GetHumidity }
     * 
     */
    public GetHumidity createGetHumidity() {
        return new GetHumidity();
    }

    /**
     * Create an instance of {@link SetOnLightResponse }
     * 
     */
    public SetOnLightResponse createSetOnLightResponse() {
        return new SetOnLightResponse();
    }

    /**
     * Create an instance of {@link SetOnSocketResponse }
     * 
     */
    public SetOnSocketResponse createSetOnSocketResponse() {
        return new SetOnSocketResponse();
    }

    /**
     * Create an instance of {@link SetOnSocket }
     * 
     */
    public SetOnSocket createSetOnSocket() {
        return new SetOnSocket();
    }

    /**
     * Create an instance of {@link GetHumidityResponse }
     * 
     */
    public GetHumidityResponse createGetHumidityResponse() {
        return new GetHumidityResponse();
    }

    /**
     * Create an instance of {@link SetOnLight }
     * 
     */
    public SetOnLight createSetOnLight() {
        return new SetOnLight();
    }

    /**
     * Create an instance of {@link GetOnSocket }
     * 
     */
    public GetOnSocket createGetOnSocket() {
        return new GetOnSocket();
    }

    /**
     * Create an instance of {@link GetOnLightResponse }
     * 
     */
    public GetOnLightResponse createGetOnLightResponse() {
        return new GetOnLightResponse();
    }

    /**
     * Create an instance of {@link GetTemperatureResponse }
     * 
     */
    public GetTemperatureResponse createGetTemperatureResponse() {
        return new GetTemperatureResponse();
    }

    /**
     * Create an instance of {@link GetOnSocketResponse }
     * 
     */
    public GetOnSocketResponse createGetOnSocketResponse() {
        return new GetOnSocketResponse();
    }

    /**
     * Create an instance of {@link GetTemperature }
     * 
     */
    public GetTemperature createGetTemperature() {
        return new GetTemperature();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSWOTApplicationNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "getSWOTApplicationNameResponse")
    public JAXBElement<GetSWOTApplicationNameResponse> createGetSWOTApplicationNameResponse(GetSWOTApplicationNameResponse value) {
        return new JAXBElement<GetSWOTApplicationNameResponse>(_GetSWOTApplicationNameResponse_QNAME, GetSWOTApplicationNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTemperature }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "getTemperature")
    public JAXBElement<GetTemperature> createGetTemperature(GetTemperature value) {
        return new JAXBElement<GetTemperature>(_GetTemperature_QNAME, GetTemperature.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOnSocketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "getOnSocketResponse")
    public JAXBElement<GetOnSocketResponse> createGetOnSocketResponse(GetOnSocketResponse value) {
        return new JAXBElement<GetOnSocketResponse>(_GetOnSocketResponse_QNAME, GetOnSocketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHumidity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "getHumidity")
    public JAXBElement<GetHumidity> createGetHumidity(GetHumidity value) {
        return new JAXBElement<GetHumidity>(_GetHumidity_QNAME, GetHumidity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOnLightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "getOnLightResponse")
    public JAXBElement<GetOnLightResponse> createGetOnLightResponse(GetOnLightResponse value) {
        return new JAXBElement<GetOnLightResponse>(_GetOnLightResponse_QNAME, GetOnLightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOnSocket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "setOnSocket")
    public JAXBElement<SetOnSocket> createSetOnSocket(SetOnSocket value) {
        return new JAXBElement<SetOnSocket>(_SetOnSocket_QNAME, SetOnSocket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOnLight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "setOnLight")
    public JAXBElement<SetOnLight> createSetOnLight(SetOnLight value) {
        return new JAXBElement<SetOnLight>(_SetOnLight_QNAME, SetOnLight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOnSocketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "setOnSocketResponse")
    public JAXBElement<SetOnSocketResponse> createSetOnSocketResponse(SetOnSocketResponse value) {
        return new JAXBElement<SetOnSocketResponse>(_SetOnSocketResponse_QNAME, SetOnSocketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHumidityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "getHumidityResponse")
    public JAXBElement<GetHumidityResponse> createGetHumidityResponse(GetHumidityResponse value) {
        return new JAXBElement<GetHumidityResponse>(_GetHumidityResponse_QNAME, GetHumidityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOnLightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "setOnLightResponse")
    public JAXBElement<SetOnLightResponse> createSetOnLightResponse(SetOnLightResponse value) {
        return new JAXBElement<SetOnLightResponse>(_SetOnLightResponse_QNAME, SetOnLightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOnSocket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "getOnSocket")
    public JAXBElement<GetOnSocket> createGetOnSocket(GetOnSocket value) {
        return new JAXBElement<GetOnSocket>(_GetOnSocket_QNAME, GetOnSocket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOnLight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "getOnLight")
    public JAXBElement<GetOnLight> createGetOnLight(GetOnLight value) {
        return new JAXBElement<GetOnLight>(_GetOnLight_QNAME, GetOnLight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSWOTApplicationName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "getSWOTApplicationName")
    public JAXBElement<GetSWOTApplicationName> createGetSWOTApplicationName(GetSWOTApplicationName value) {
        return new JAXBElement<GetSWOTApplicationName>(_GetSWOTApplicationName_QNAME, GetSWOTApplicationName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTemperatureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://electrosocket.swot.miun.se/", name = "getTemperatureResponse")
    public JAXBElement<GetTemperatureResponse> createGetTemperatureResponse(GetTemperatureResponse value) {
        return new JAXBElement<GetTemperatureResponse>(_GetTemperatureResponse_QNAME, GetTemperatureResponse.class, null, value);
    }

}
