package se.miun.swot.electrosocket;

public class SensorPollServiceProxy implements se.miun.swot.electrosocket.SensorPollService_PortType {
  private String _endpoint = null;
  private se.miun.swot.electrosocket.SensorPollService_PortType sensorPollService_PortType = null;
  
  public SensorPollServiceProxy() {
    _initSensorPollServiceProxy();
  }
  
  public SensorPollServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSensorPollServiceProxy();
  }
  
  private void _initSensorPollServiceProxy() {
    try {
      sensorPollService_PortType = (new se.miun.swot.electrosocket.SensorPollService_ServiceLocator()).getSensorPollServicePort();
      if (sensorPollService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sensorPollService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sensorPollService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sensorPollService_PortType != null)
      ((javax.xml.rpc.Stub)sensorPollService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public se.miun.swot.electrosocket.SensorPollService_PortType getSensorPollService_PortType() {
    if (sensorPollService_PortType == null)
      _initSensorPollServiceProxy();
    return sensorPollService_PortType;
  }
  
  public java.lang.String getSWOTApplicationName() throws java.rmi.RemoteException{
    if (sensorPollService_PortType == null)
      _initSensorPollServiceProxy();
    return sensorPollService_PortType.getSWOTApplicationName();
  }
  
  public int getTemperature() throws java.rmi.RemoteException{
    if (sensorPollService_PortType == null)
      _initSensorPollServiceProxy();
    return sensorPollService_PortType.getTemperature();
  }
  
  public int getHumidity() throws java.rmi.RemoteException{
    if (sensorPollService_PortType == null)
      _initSensorPollServiceProxy();
    return sensorPollService_PortType.getHumidity();
  }
  
  public boolean getOnLight() throws java.rmi.RemoteException{
    if (sensorPollService_PortType == null)
      _initSensorPollServiceProxy();
    return sensorPollService_PortType.getOnLight();
  }
  
  public boolean getOnSocket() throws java.rmi.RemoteException{
    if (sensorPollService_PortType == null)
      _initSensorPollServiceProxy();
    return sensorPollService_PortType.getOnSocket();
  }
  
  public void setOnLight(boolean state) throws java.rmi.RemoteException{
    if (sensorPollService_PortType == null)
      _initSensorPollServiceProxy();
    sensorPollService_PortType.setOnLight(state);
  }
  
  public void setOnSocket(boolean state) throws java.rmi.RemoteException{
    if (sensorPollService_PortType == null)
      _initSensorPollServiceProxy();
    sensorPollService_PortType.setOnSocket(state);
  }
  
  
}