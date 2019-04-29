package com.mnt.sensor_master.dto;

public class SensorDto {
	public Long id;
	public String mac;
	public String deviceId;
	public boolean pin1;
	public boolean pin2;
	public int POSTInterval;
	public int GETInterval;
	public String token;
	public String userEmail;
	public String kommentar;
	public int prem;
	public int pay;
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public boolean isPin1() {
		return pin1;
	}
	public void setPin1(boolean pin1) {
		this.pin1 = pin1;
	}
	public boolean isPin2() {
		return pin2;
	}
	public void setPin2(boolean pin2) {
		this.pin2 = pin2;
	}
	public int getPOSTInterval() {
		return POSTInterval;
	}
	public void setPOSTInterval(int pOSTInterval) {
		POSTInterval = pOSTInterval;
	}
	public int getGETInterval() {
		return GETInterval;
	}
	public void setGETInterval(int gETInterval) {
		GETInterval = gETInterval;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getKommentar() {
		return kommentar;
	}
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}
	public int getPrem() {
		return prem;
	}
	public void setPrem(int prem) {
		this.prem = prem;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
}
