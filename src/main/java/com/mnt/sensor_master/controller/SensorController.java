package com.mnt.sensor_master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mnt.sensor_master.dto.SensorDto;
import com.mnt.sensor_master.dto.ServerResult;
import com.mnt.sensor_master.entity.Sensor;
import com.mnt.sensor_master.service.SensorService;

@RestController
@RequestMapping("/api/")
public class SensorController {
	
	@Autowired
	SensorService sensorService;
	
	@GetMapping(value = "/sensor/list")
	public ServerResult getSensors() {
		return sensorService.getSensors();
	}
	@GetMapping(value = "/sensor/{id}")
	public ServerResult getOneSensors(@PathVariable Long id) {
		return sensorService.getOneSensor(id);
	}
	
	@PostMapping(value="/saveSensor")
	public ServerResult saveSensor(@RequestBody SensorDto sensorDto) {
		return sensorService.saveSensor(sensorDto);
	}
	
	@PutMapping(value="/updateSensor")
	public ServerResult updateSensor(@RequestBody SensorDto sensorDto) {
		return sensorService.updateSensor(sensorDto);
	}
	
	@DeleteMapping(value = "/sensor/{id}")
	public ServerResult deleteOneSensors(@PathVariable Long id) {
		return sensorService.deleteOneSensor(id);
	}
}
