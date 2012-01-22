package com.miun.sensors;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Socket")
public class Socket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="TEMPERATURE")
	private int temperature;
	
	@Column(name="HUMIDITY")
	private int humidity;
	
	@Column(name="LIGHT")
	private boolean light;
	
	@Column(name="SOCKET")
	private boolean socket;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}

	public boolean isSocket() {
		return socket;
	}

	public void setSocket(boolean socket) {
		this.socket = socket;
	}

	
	
}
