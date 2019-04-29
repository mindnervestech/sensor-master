package com.mnt.sensor_master.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.sensor_master.dto.ServerResult;
import com.mnt.sensor_master.entity.PasswordResetToken;
import com.mnt.sensor_master.entity.User;
import com.mnt.sensor_master.repository.PasswordResetTokenRepository;
import com.mnt.sensor_master.repository.UserRepository;
import com.mnt.sensor_master.utils.Mail;
import com.mnt.sensor_master.utils.MailService;

@Service
public class EmailService {
	
	@Autowired
	MailService mailService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordResetTokenRepository tokenRepository;
	
	@Autowired
	UserRepository userRepository;

	public ServerResult sendResetPasswordMail(String email)
	{
		ServerResult result = new ServerResult();
		Mail mail = new Mail();
		User user = userService.findByEmail(email);
		//mail.setMailFrom("mindnervesdemo@gmail.com"); //"mindnervesdemo@gmail.com"
		if(user != null){
			
			//saving token
			String token = UUID.randomUUID().toString();
			createPasswordResetTokenForUser(user, token);
			
			//sending email
			mail.setMailTo(user.getEmail());
			mail.setMailSubject("Reset Password");
	 
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("url", "http://localhost:3000/resetPassword/upn=" + token);
			model.put("token", token);
			model.put("firstName", user.getFirstName());
			mail.setModel(model);
			try {
				mailService.sendEmail(mail,"reset-password.ftl" );
				result.put("status", "success");
				result.put("code", 200);
				result.setMessage("Password sent on your given Email id");
				return result;
			} catch (Exception e) {
				result.put("status", "error");
				result.put("code", 500);
				result.setMessage("Failed to send email");
				e.printStackTrace();
				return result;
			}
		} else {
			result.put("code", 201);
			result.put("status", "emailNotRegistered");
			result.setMessage("Email id not registered");
			return result;
		}
		
	}
	
	public void createPasswordResetTokenForUser(User user, String token) {
		PasswordResetToken prevToken = tokenRepository.findByUser(user);
		if(prevToken != null)
			tokenRepository.delete(prevToken);
	    PasswordResetToken myToken = new PasswordResetToken(token, user);
	    tokenRepository.save(myToken);
	}

	public ServerResult changePassword(HashMap<String, String> request) {
		// TODO Auto-generated method stub
		ServerResult res = new ServerResult();
		String token = request.get("token");
		if(token == null){
			res.setCode(400); //bad request
			res.put("status", "error");
			res.setMessage("Invalid Token");
			return res;
		}
		PasswordResetToken tokenEntity = tokenRepository.findByToken(token);
		if(tokenEntity == null){
			res.setCode(401); //expired token
			res.put("status", "error");
			res.setMessage("Token Expired. Please resubmit the request to change the password.");
			return res;
		}
		if(tokenEntity.getToken().equals(token)){
			//todo
			//check if token is expired....
			
			
			User user = tokenEntity.getUser();
			user.setPassword(request.get("password"));
			userRepository.save(user);
			tokenRepository.delete(tokenEntity);
			
			Mail mail = new Mail();
			mail.setMailTo(user.getEmail());
			mail.setMailSubject("Changed Password");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("firstName", user.getFirstName());
			mail.setModel(model);
			try {
				mailService.sendEmail(mail,"password-changed.ftl" );
				res.put("status", "success");
				res.put("code", 200);
				res.setMessage("Password updated successfully");
				return res;
			} catch (Exception e) {
				res.put("status", "error");
				res.put("code", 500);
				res.setMessage("Failed to send email");
				return res;
			}
		} else {
			res.setCode(400); //bad request
			res.put("status", "error");
			res.setMessage("Invalid Token");
			return res;
		}
	}
}
