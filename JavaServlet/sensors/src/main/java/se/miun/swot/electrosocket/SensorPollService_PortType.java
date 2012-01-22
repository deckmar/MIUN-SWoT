/**
 * SensorPollService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package se.miun.swot.electrosocket;

public interface SensorPollService_PortType extends java.rmi.Remote {
    public java.lang.String getSWOTApplicationName() throws java.rmi.RemoteException;
    public int getTemperature() throws java.rmi.RemoteException;
    public int getHumidity() throws java.rmi.RemoteException;
    public boolean getOnLight() throws java.rmi.RemoteException;
    public boolean getOnSocket() throws java.rmi.RemoteException;
    public void setOnLight(boolean state) throws java.rmi.RemoteException;
    public void setOnSocket(boolean state) throws java.rmi.RemoteException;
}
