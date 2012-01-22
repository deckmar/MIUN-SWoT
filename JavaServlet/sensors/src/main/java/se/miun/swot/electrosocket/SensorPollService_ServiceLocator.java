/**
 * SensorPollService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package se.miun.swot.electrosocket;

public class SensorPollService_ServiceLocator extends org.apache.axis.client.Service implements se.miun.swot.electrosocket.SensorPollService_Service {

    public SensorPollService_ServiceLocator() {
    	this.SensorPollServicePort_address = "http://79.136.36.225:8080/ElectroSocketService2.0/SensorPollService";
    }
    
    //Custom
    public SensorPollService_ServiceLocator(java.lang.String address) {
    	this.SensorPollServicePort_address = address;
    }

    public SensorPollService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
        this.SensorPollServicePort_address = "http://79.136.36.225:8080/ElectroSocketService2.0/SensorPollService";
    }

    public SensorPollService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
        this.SensorPollServicePort_address = "http://79.136.36.225:8080/ElectroSocketService2.0/SensorPollService";
    }

    // Use to get a proxy class for SensorPollServicePort
    private java.lang.String SensorPollServicePort_address;

    public java.lang.String getSensorPollServicePortAddress() {
        return SensorPollServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SensorPollServicePortWSDDServiceName = "SensorPollServicePort";

    public java.lang.String getSensorPollServicePortWSDDServiceName() {
        return SensorPollServicePortWSDDServiceName;
    }

    public void setSensorPollServicePortWSDDServiceName(java.lang.String name) {
        SensorPollServicePortWSDDServiceName = name;
    }

    public se.miun.swot.electrosocket.SensorPollService_PortType getSensorPollServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SensorPollServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSensorPollServicePort(endpoint);
    }

    public se.miun.swot.electrosocket.SensorPollService_PortType getSensorPollServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            se.miun.swot.electrosocket.SensorPollServicePortBindingStub _stub = new se.miun.swot.electrosocket.SensorPollServicePortBindingStub(portAddress, this);
            _stub.setPortName(getSensorPollServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSensorPollServicePortEndpointAddress(java.lang.String address) {
        SensorPollServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (se.miun.swot.electrosocket.SensorPollService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                se.miun.swot.electrosocket.SensorPollServicePortBindingStub _stub = new se.miun.swot.electrosocket.SensorPollServicePortBindingStub(new java.net.URL(SensorPollServicePort_address), this);
                _stub.setPortName(getSensorPollServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SensorPollServicePort".equals(inputPortName)) {
            return getSensorPollServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://electrosocket.swot.miun.se/", "SensorPollService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://electrosocket.swot.miun.se/", "SensorPollServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SensorPollServicePort".equals(portName)) {
            setSensorPollServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
