package com.mnt.sensor_master.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import com.mnt.sensor_master.entity.base.LongIdBaseEntity;

@Entity
@Table(name="alarms")
public class Alarms extends LongIdBaseEntity{

@Column(nullable = false, length = 50)
public String sensorName;

@Column(nullable = false, length = 50)
public String alarmName;

@Column(length = 50)
public Long minValue;

@Column(length = 50)
public Long maxValue;

public Boolean isActivate;

public String getSensorName() {
	return sensorName;
}

public void setSensorName(String sensorName) {
	this.sensorName = sensorName;
}

public String getAlarmName() {
	return alarmName;
}

public void setAlarmName(String alarmName) {
	this.alarmName = alarmName;
}

public Long getMinValue() {
	return minValue;
}

public void setMinValue(Long minValue) {
	this.minValue = minValue;
}

public Long getMaxValue() {
	return maxValue;
}

public void setMaxValue(Long maxValue) {
	this.maxValue = maxValue;
}

public Boolean getIsActivate() {
	return isActivate;
}

public void setIsActivate(Boolean isActivate) {
	this.isActivate = isActivate;
}



}