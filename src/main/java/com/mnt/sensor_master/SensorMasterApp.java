package com.mnt.sensor_master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SensorMasterApp 
{
	public static void main( String[] args )
    {
        SpringApplication.run(SensorMasterApp.class, args);   
    }
    
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//     return new BCryptPasswordEncoder();
//    }
}
