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

import com.mnt.sensor_master.dto.AlarmsDto;
import com.mnt.sensor_master.dto.ServerResult;
import com.mnt.sensor_master.service.AlarmService;

@RestController
@RequestMapping("/api")
public class AlarmsController {
	
	@Autowired
	AlarmService alarmService;

	@GetMapping(value = "/alarms/list")
	public ServerResult getAlarms() {
		return alarmService.getAlarms();
	}
	
	@GetMapping(value = "/alarm/{id}")
	public ServerResult getOneAlarm(@PathVariable Long id) {
		return alarmService.getOneAlarm(id);
	}
		
	@PostMapping(value="/saveAlarm")
	public ServerResult saveAlarms(@RequestBody AlarmsDto alarmsDto) {
		
		return alarmService.saveAlarm(alarmsDto);
	}
	
	@PutMapping(value = "/updateAlarm")
	public ServerResult updateAlarm(@RequestBody AlarmsDto alarmsDto) {
		return alarmService.updateAlarm(alarmsDto);
	}
	
	@DeleteMapping(value = "/alarm/{id}")
	public ServerResult deleteAlarm(@PathVariable Long id) {
		return alarmService.deleteteAlarm(id);
	}
	
}
