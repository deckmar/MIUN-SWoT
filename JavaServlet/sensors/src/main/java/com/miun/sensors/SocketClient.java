package com.miun.sensors;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import se.miun.swot.electrosocket.SensorPollService_PortType;
import se.miun.swot.electrosocket.SensorPollService_ServiceLocator;

public class SocketClient {
	SensorPollService_ServiceLocator socketService;
	SensorPollService_PortType port;
	
	public SocketClient() throws ServiceException{
		socketService = new SensorPollService_ServiceLocator("http://79.136.36.225:8080/ElectroSocketService2.0/SensorPollService");
		port = socketService.getSensorPollServicePort();
	}
	
	public SocketClient(String address) throws ServiceException{
		socketService = new SensorPollService_ServiceLocator(address);
		port = socketService.getSensorPollServicePort();
	}

	public String GetAddress(){
		return socketService.getSensorPollServicePortAddress();
	}
	public int GetTemperature() throws RemoteException{	
		return port.getTemperature();
	}
	
	public int GetHumidity() throws RemoteException{
		return port.getHumidity();
	}
	
	public boolean IsLightOn() throws RemoteException {
		return port.getOnLight();
	}
	
	public boolean IsSocketOn() throws RemoteException {
		return port.getOnSocket();
	}
	public void SetLightOn(boolean lightOn) throws RemoteException {
		port.setOnLight(lightOn);
	}
    public void SetSocketOn(boolean socketOn) throws RemoteException {
    	port.setOnSocket(socketOn);
    }
	
}
