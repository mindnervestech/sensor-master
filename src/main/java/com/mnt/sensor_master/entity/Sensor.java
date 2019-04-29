package com.mnt.sensor_master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mnt.sensor_master.entity.base.LongIdBaseEntity;

@Entity
@Table(name = "sensors")
public class Sensor extends LongIdBaseEntity{

	@Column(nullable = false, length=60)
	private String mac;
	
	@Column(name="deviceid", length=60)
	private String deviceId;
	
	@Column(name="pin1")
	private boolean pin1;
	
	@Column(name="pin2")
	private boolean pin2;
	
	@Column(name="POSTinterval")
	private int POSTInterval;
	
	@Column(name="GETinterval")
	private int GETInterval;
	
	@Column(name="token")
	private String token;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="Kommentar")
	private String kommentar;
	
	@Column(name="prem")
	private int prem;
	
	@Column(name="pay")
	private int pay;

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
