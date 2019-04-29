package com.mnt.sensor_master.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mnt.sensor_master.entity.base.LongIdBaseEntity;

@Entity
@Table(name = "password_reset_token")
public class PasswordResetToken extends LongIdBaseEntity {
	
	private static final int EXPIRATION = 24*60*60*1000;
	
	@Column(name="token")
	private String token;
	
	@OneToOne(targetEntity = User.class, fetch=FetchType.EAGER)
	@JoinColumn(nullable = false, name="user_id")
	private User user;
	
	@Column(name="expiry_date")
	private Date expiryDate;

	public PasswordResetToken() {}
	
	public PasswordResetToken(String token, User user) {
		this.token = token;
		this.user = user;
		this.expiryDate = new Date(new Date().getTime() + EXPIRATION);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public static int getExpiration() {
		return EXPIRATION;
	}
	
}
