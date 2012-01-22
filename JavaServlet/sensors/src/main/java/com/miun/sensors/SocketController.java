package com.miun.sensors;


import java.rmi.RemoteException;

import javax.annotation.Resource;
import javax.xml.rpc.ServiceException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/socket")
public class SocketController {
	
	@Resource(name="socketService")
	private SocketService socketService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String get(Model model) {
		
		try {
			
			SocketClient socketClient = new SocketClient();
			Socket socket = new Socket();
			
			//Standard socket
			socket.setAddress(socketClient.GetAddress());
			socket.setId(1);
			
			
			int temp = socketClient.GetTemperature();
			int humi = socketClient.GetHumidity();
			boolean lightOn = socketClient.IsLightOn();
			boolean socketOn = socketClient.IsSocketOn();
			
			socket.setTemperature(temp);
			socket.setHumidity(humi);
			socket.setLight(lightOn);
			socket.setSocket(socketOn);
			
			socketService.update(socket);
			
			String lightIs;
			String turnLight;
			if(lightOn){
				lightIs = "On";
				turnLight = "Off";
			} else {
				lightIs = "Off";
				turnLight = "On";
			}
			
			String socketIs;
			String turnSocket;
			if(socketOn){
				socketIs = "On";
				turnSocket = "Off";
			} else {
				socketIs = "Off";
				turnSocket = "On";
			}
			
			model.addAttribute("temperature", temp);
			model.addAttribute("humidity", humi);
			model.addAttribute("lightIs", lightIs);
			model.addAttribute("turnLight", turnLight);
			model.addAttribute("socketIs", socketIs);
			model.addAttribute("turnSocket", turnSocket);
			
			return "socket";
		} catch (ServiceException se) {
			return "socketError";
		} catch (RemoteException re) {
			return "socketError";
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getSocketId(@PathVariable long id, Model model) {
		try {
			
			Socket socket = socketService.get(id);
			if(socket == null) {
				return "socketError";
			}
			
			SocketClient socketClient = new SocketClient(socket.getAddress());
			
			
			
			
			int temp = socketClient.GetTemperature();
			int humi = socketClient.GetHumidity();
			boolean lightOn = socketClient.IsLightOn();
			boolean socketOn = socketClient.IsSocketOn();
			
			socket.setTemperature(temp);
			socket.setHumidity(humi);
			socket.setLight(lightOn);
			socket.setSocket(socketOn);
			
			socketService.update(socket);
			
			String lightIs;
			String turnLight;
			if(lightOn){
				lightIs = "On";
				turnLight = "Off";
			} else {
				lightIs = "Off";
				turnLight = "On";
			}
			
			String socketIs;
			String turnSocket;
			if(socketOn){
				socketIs = "On";
				turnSocket = "Off";
			} else {
				socketIs = "Off";
				turnSocket = "On";
			}
			
			model.addAttribute("temperature", temp);
			model.addAttribute("humidity", humi);
			model.addAttribute("lightIs", lightIs);
			model.addAttribute("turnLight", turnLight);
			model.addAttribute("socketIs", socketIs);
			model.addAttribute("turnSocket", turnSocket);
			
			return "socket";
		} catch (ServiceException se) {
			return "socketError";
		} catch (RemoteException re) {
			return "socketError";
		}
	}
	
	@RequestMapping(value = "/turnLight", method = RequestMethod.POST)
	public String setLight(@RequestParam("turn") String turn){
		try {
			SocketClient socketClient = new SocketClient();
			boolean onOff;
			if(turn == "On"){
				onOff = true;
			} else {
				onOff = false;
			}
			socketClient.SetLightOn(onOff);
			Socket socket = socketService.get(1);
			socket.setLight(onOff);
			socketService.update(socket);
			return "socket";
		} catch (ServiceException se) {
			return "socketError";
		} catch (RemoteException re) {
			return "socketError";
		}
	}
	
	@RequestMapping(value = "/{id}/turnLight", method = RequestMethod.POST)
	public String setLightId(@PathVariable long id, @RequestParam("turn") String turn){
		try {
			Socket socket = socketService.get(id);
			if(socket == null) {
				return "socketError";
			}
			
			SocketClient socketClient = new SocketClient(socket.getAddress());
			boolean onOff;
			if(turn == "On"){
				onOff = true;
			} else {
				onOff = false;
			}
			socketClient.SetLightOn(onOff);
			return "socket";
		} catch (ServiceException se) {
			return "socketError";
		} catch (RemoteException re) {
			return "socketError";
		}
	}
	
	@RequestMapping(value = "/turnSocket", method = RequestMethod.POST)
	public String setSocket(@RequestParam("turn") String turn){
		try {
			SocketClient socketClient = new SocketClient();
			boolean onOff;
			if(turn == "On"){
				onOff = true;
			} else {
				onOff = false;
			}
			socketClient.SetSocketOn(onOff);
			Socket socket = socketService.get(1);
			socket.setSocket(onOff);
			socketService.update(socket);
			return "socket";
		} catch (ServiceException se) {
			return "socketError";
		} catch (RemoteException re) {
			return "socketError";
		}
	}
	
	@RequestMapping(value = "/{id}/turnSocket", method = RequestMethod.POST)
	public String setSocketId(@PathVariable long id, @RequestParam("turn") String turn){
		try {
			Socket socket = socketService.get(id);
			if(socket == null) {
				return "socketError";
			}
			
			SocketClient socketClient = new SocketClient(socket.getAddress());
			boolean onOff;
			if(turn == "On"){
				onOff = true;
			} else {
				onOff = false;
			}
			socketClient.SetSocketOn(onOff);
			return "socket";
		} catch (ServiceException se) {
			return "socketError";
		} catch (RemoteException re) {
			return "socketError";
		}
	}
	
}
