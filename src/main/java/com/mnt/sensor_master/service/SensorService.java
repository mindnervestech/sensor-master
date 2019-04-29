package com.mnt.sensor_master.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.sensor_master.dto.SensorDto;
import com.mnt.sensor_master.dto.ServerResult;
import com.mnt.sensor_master.entity.Sensor;
import com.mnt.sensor_master.repository.SensorRepository;

@Service
public class SensorService {

	@Autowired
	SensorRepository sensorRepository;

	public ServerResult getSensors() {
		ServerResult result = new ServerResult();
		result.setData(sensorRepository.findAll());
		result.setCode(200);
		result.setMessage("Success");
		 return null;
	}

	public ServerResult getOneSensor(Long id) {
		ServerResult result =	new ServerResult();
	Optional<Sensor> sensor =	sensorRepository.findById(id);
	if(Objects.nonNull(sensor)) {
		result.setData(sensor);
		result.setCode(200);
		result.setMessage("sensor found");
	}else {
		result.setCode(500);
		result.setMessage("sensor not found");
	}
		return result;
	}

	public ServerResult saveSensor(SensorDto sensorDto) {
		ServerResult result =	new ServerResult();
		Sensor sensor = new Sensor();
		sensor.setDeviceId(sensorDto.getDeviceId());
		sensor.setGETInterval(sensorDto.getGETInterval());
		sensor.setKommentar(sensorDto.getKommentar());
		sensor.setMac(sensorDto.getMac());
		sensor.setPay(sensorDto.getPay());
		sensor.setPin1(sensorDto.pin1);
		sensor.setPin2(sensorDto.pin2);
		sensor.setPOSTInterval(sensorDto.getPOSTInterval());
		sensor.setPrem(sensorDto.getPrem());
		sensor.setToken(sensorDto.getToken());
		sensor.setUserEmail(sensorDto.getUserEmail());
		sensorRepository.save(sensor);
		result.setData(sensor);
		result.setCode(200);
		result.setMessage("sensor created successfully");
		return result;
	}

	public ServerResult updateSensor(SensorDto sensorDto) {
		Optional<Sensor> sensorfinder = sensorRepository.findById(sensorDto.getId());

		ServerResult result =	new ServerResult();
		if(Objects.nonNull(sensorfinder.get())) {
		Sensor sensor = new Sensor();
		sensor.setId(sensorDto.getId());
		sensor.setDeviceId(sensorDto.getDeviceId());
		sensor.setGETInterval(sensorDto.getGETInterval());
		sensor.setKommentar(sensorDto.getKommentar());
		sensor.setMac(sensorDto.getMac());
		sensor.setPay(sensorDto.getPay());
		sensor.setPin1(sensorDto.pin1);
		sensor.setPin2(sensorDto.pin2);
		sensor.setPOSTInterval(sensorDto.getPOSTInterval());
		sensor.setPrem(sensorDto.getPrem());
		sensor.setToken(sensorDto.getToken());
		sensor.setUserEmail(sensorDto.getUserEmail());
		sensorRepository.save(sensor);
		result.setData(sensor);
		result.setCode(200);
		result.setMessage("sensor updated successfully");
		} else {
			result.setCode(500);
			result.setMessage("sensor not found");
		}
		return result;
	}

	public ServerResult deleteOneSensor(Long id) {
		sensorRepository.deleteById(id);
		return new ServerResult().setCode(200).setMessage("success");
	}

}
