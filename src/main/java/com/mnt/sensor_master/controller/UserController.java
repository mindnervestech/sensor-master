package com.mnt.sensor_master.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mnt.sensor_master.dto.ServerResult;
import com.mnt.sensor_master.dto.UserDto;
import com.mnt.sensor_master.entity.User;
import com.mnt.sensor_master.security.SecurityTokenHandler;
import com.mnt.sensor_master.service.EmailService;
import com.mnt.sensor_master.service.UserService;

@RestController
@RequestMapping("/api/")
public class UserController {
	
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityTokenHandler securityTokenHandler;
    
    @Autowired
    EmailService emailService;
	
	@PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response, @RequestBody User userEntity) throws IOException {
        ServerResult result = new ServerResult();
        User user = userService.findByEmail(userEntity.getEmail());

        if (user != null) {
            //if (user.isPasswordSet()) {
                if (Objects.isNull(userEntity.getPassword()) || userEntity.getPassword().isEmpty()) {
                    result.put("status", "isPasswordSet");
                } else {
                    if (user.getPassword().equals(userEntity.getPassword())) {
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        result.put("token", securityTokenHandler.getToken(user));
                        result.put("status", "success");
                        result.put("message", "Login Successfully");
                        result.put("code", 200);
                        result.put("user", user);
                    } else {
                        result.put("message", "Wrong password");
                    }
                }
                return result;
//            } else {
//                result.put("code", 201);
//                result.put("status", "isPasswordNotSet");
//                result.put("message", "Password not setted");
//                return result;
//            }
        } else {
            result.put("code", 201);
            result.put("message", "Username not registered");
        }
        return result;
    }
	
	@GetMapping(value = "/logout")
    @ResponseBody
    public ResponseEntity<ServerResult> logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServerResult result = new ServerResult();
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.invalidate();
        result.setMessage("Logout successfully");
        result.setCode(200);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@PostMapping(value= "/user/{id}")
	@ResponseBody
	public ServerResult getUser(HttpServletRequest request, @PathVariable Long id){
		ServerResult result = new ServerResult();
		try{
			Optional<User> user = userService.findById(id);
			result.put("code", 200L);
			result.put("status", "success");
			result.put("data", user);
		} catch(Exception e){
			result.put("code", 500L);
			result.put("status", "error");
		}
		return result;
	}
	
	@PostMapping(value= "/resetPassword")
	@ResponseBody
	public ServerResult requestResetPassword(@RequestBody HashMap<String,String> request){
		return emailService.sendResetPasswordMail(request.get("email"));
	}
	
	@PostMapping(value= "/changePassword")
	@ResponseBody
	public ServerResult savePassword(@RequestBody HashMap<String, String> request) {
		return emailService.changePassword(request);
	}
	
	@PostMapping(value= "/user")
	@ResponseBody
	public ServerResult saveUser(@RequestBody UserDto userDto) {
		return userService.save(userDto);
	}
	
	@PostMapping(value= "/changeState/{id}")
	@ResponseBody
	public ServerResult changeState(@PathVariable Long id) {
		return userService.changeState(id);
	}
}
	// http://javabycode.com/spring-framework-tutorial/spring-boot-tutorial/spring-boot-freemarker-email-template.html
	
	
