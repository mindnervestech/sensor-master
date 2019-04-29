package com.mnt.sensor_master.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mnt.sensor_master.entity.SensorData;

@Repository
public interface SensorDataRepository extends CrudRepository<SensorData, Long>{

}
