package com.mnt.sensor_master.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mnt.sensor_master.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
    
    public Optional<User> findById(Long id);

    //List<User> findAllByUserRole(String userRole);

    //List<User> findAllByBuildingsAndUserRole(List<BuildingsEntity> buildings, String role);

}