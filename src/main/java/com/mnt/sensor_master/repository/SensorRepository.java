package com.mnt.sensor_master.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mnt.sensor_master.entity.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long>{

}
