package com.mnt.sensor_master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mnt.sensor_master.entity.base.LongIdBaseEntity;

@Entity
@Table(name = "sensordata")
public class SensorData extends LongIdBaseEntity {

	@Column(nullable = false, length=60)
	private String mac;
	
	@Column(name="deviceid", length=60)
	private String deviceId;
	
	@Column(name="time")
	private long time;
	
	@Column(name="sensor1")
	private double sensor1;
	
	@Column(name="sensor2")
	private double sensor2;
	
	@Column(name="sensor3")
	private double sensor3;
	
	@Column(name="sensor4")
	private double sensor4;
	
	@Column(name="analog")
	private boolean analog;
	
	@Column(name="pin1")
	private boolean pin1;
	
	@Column(name="pin2")
	private boolean pin2;

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

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getSensor1() {
		return sensor1;
	}

	public void setSensor1(double sensor1) {
		this.sensor1 = sensor1;
	}

	public double getSensor2() {
		return sensor2;
	}

	public void setSensor2(double sensor2) {
		this.sensor2 = sensor2;
	}

	public double getSensor3() {
		return sensor3;
	}

	public void setSensor3(double sensor3) {
		this.sensor3 = sensor3;
	}

	public double getSensor4() {
		return sensor4;
	}

	public void setSensor4(double sensor4) {
		this.sensor4 = sensor4;
	}

	public boolean isAnalog() {
		return analog;
	}

	public void setAnalog(boolean analog) {
		this.analog = analog;
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
	
}
