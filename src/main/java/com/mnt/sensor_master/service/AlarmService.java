package com.mnt.sensor_master.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mnt.sensor_master.dto.AlarmsDto;
import com.mnt.sensor_master.dto.ServerResult;
import com.mnt.sensor_master.entity.Alarms;
import com.mnt.sensor_master.repository.AlarmsRepository;

@Service
public class AlarmService {

	@Autowired
	AlarmsRepository alarmsRepository;

	public ServerResult getAlarms() {
		return new ServerResult().setData(alarmsRepository.findAll()).setCode(200).setMessage("Success");
	}

	public ServerResult saveAlarm(AlarmsDto alarmsDto) {
		ServerResult result = new ServerResult();
		Alarms alarms = new Alarms();
		alarms.setAlarmName(alarmsDto.getAlarmName());
		alarms.setSensorName(alarmsDto.getSensorName());
		alarms.setMinValue(alarmsDto.getMinValue());
		alarms.setMaxValue(alarmsDto.getMaxValue());
		alarms.setIsActivate(alarmsDto.getIsActivate());
		alarmsRepository.save(alarms);
		result.setData(alarms);
		result.setCode(200);
		result.setMessage("Alarm created successfully");
		return result;
	}

	public ServerResult getOneAlarm(Long id) {
		ServerResult result = new ServerResult();
		Optional<Alarms> alarms = alarmsRepository.findById(id);
		if(Objects.nonNull(alarms.get())) {
			result.setData(alarms);
			result.setCode(200);
			result.setMessage("Alarm is available");
		}else {
			result.setCode(500);
			result.setMessage("Alarm is not available");
		}
		return result;
	}

	public ServerResult updateAlarm(AlarmsDto alarm) {
		ServerResult result = new ServerResult();
		Optional<Alarms> alarms = alarmsRepository.findById(alarm.getId());
		if(Objects.nonNull(alarms.get())) {
			Alarms alarms2 = new Alarms();
			alarms2.setId(alarm.getId());
			alarms2.setAlarmName(alarm.getAlarmName());
			alarms2.setSensorName(alarm.getSensorName());
			alarms2.setMinValue(alarm.getMinValue());
			alarms2.setMaxValue(alarm.getMaxValue());
			alarms2.setIsActivate(alarm.getIsActivate());
			alarmsRepository.save(alarms2);
			result.setData(alarms2);
			result.setCode(200);
			result.setMessage("Alarm updateded SuccessFully");
		}else {
			result.setCode(400);
			result.setMessage("Alarm Not Found");
		}
		return result;
	}

	public ServerResult deleteteAlarm(Long id) {
		ServerResult result = new ServerResult();
		Optional<Alarms> alarms = alarmsRepository.findById(id);
		if(Objects.nonNull(alarms.get())) {
			alarmsRepository.deleteById(id);
			result.setCode(200);
			result.setMessage("Alarm removeded SuccessFully");
		}else {
			result.setCode(500);
			result.setMessage("Alarm is not available");
		}
		return result;
	}
}
