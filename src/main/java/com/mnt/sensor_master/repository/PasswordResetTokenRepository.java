package com.mnt.sensor_master.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mnt.sensor_master.entity.PasswordResetToken;
import com.mnt.sensor_master.entity.User;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
	
	public PasswordResetToken findByToken(String token);
	
	public Optional<PasswordResetToken> findById(Long id);
	
	public PasswordResetToken findByUser(User user);
}
