package com.mnt.sensor_master.service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mnt.sensor_master.dto.ServerResult;
import com.mnt.sensor_master.dto.UserDto;
import com.mnt.sensor_master.entity.User;
import com.mnt.sensor_master.repository.UserRepository;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public Optional<User> findById(Long id){
    	return userRepository.findById(id);
    }
    
    public ServerResult save(UserDto userDto){
    	ServerResult res = new ServerResult();
    	User user = userRepository.findByEmail(userDto.getEmail());
    	if(user != null){
    		res.setCode(409);
    		res.setMessage("Email id is already registered");
    		return res;
    	}
    	user = new User();
//    	user.setCountry(userDto.getCountry());
    	user.setCreatedDate(new Date());
    	user.setEmail(userDto.getEmail());
    	user.setFirstName(userDto.getFirstName());
//    	user.setLanguage(userDto.getLanguage());
    	user.setLastName(userDto.getLastName());
    	user.setModifiedDate(user.getCreatedDate());
    	user.setPassword(userDto.getPassword());
    	user.setActive(true);
    	user.setRole("user");
    	try{
    		userRepository.save(user);
    		res.setCode(200);
    		res.setMessage("User registered successfully");
    	} catch (Exception e){
    		e.printStackTrace();
    		res.setCode(500);
    		res.setMessage("Failed to create user");
    	}
    	return res;
    }

	public ServerResult changeState(Long id) {
		ServerResult res = new ServerResult();
    	Optional<User> user = userRepository.findById(id);
    	if(Objects.nonNull(user.get())) {
    		System.out.println(user.get().getEmail());
    		user.get().setActive(!user.get().isActive());
    		userRepository.save(user.get());
    	}
    	res.setData(user);
    	res.setCode(200);
    	res.setMessage("user found");
		return res;
	}

}
