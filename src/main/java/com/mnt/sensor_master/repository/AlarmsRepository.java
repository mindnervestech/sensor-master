package com.mnt.sensor_master.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mnt.sensor_master.entity.Alarms;

public interface AlarmsRepository extends JpaRepository<Alarms, Long> {

}
