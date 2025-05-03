package com.email.otp.emailOTPVerification.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.otp.emailOTPVerification.entity.User;
import com.email.otp.emailOTPVerification.payload.RequestDto;
import com.email.otp.emailOTPVerification.payload.ResponseDto;
import com.email.otp.emailOTPVerification.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EmailService emailService;
	
	public ResponseDto registerUser(RequestDto request) {
		ResponseDto response = new ResponseDto();
		
		User existingUser = userRepo.findByEmail(request.getEmail());
		
		if(existingUser != null) {
			response.setMessage("User Already Registered..");
		} else {
			Random random = new Random();
			String otp = String.format("%06d", random.nextInt(100000)); //100000 --> 6 digit 
			User newUser = new User();
			newUser.setUserName(request.getUserName());
			newUser.setEmail(request.getEmail());
			newUser.setOtp(otp);
			newUser.setVerified(false);
			User savedUser = this.userRepo.save(newUser);
			
			//Email Send..
			String subject = "Email OTP Verification";
			//String body = "Your Verification OTP is:" + otp ;
			String body = generateBody(request.getUserName(), otp);
			emailService.sendEmail(savedUser.getEmail(), subject, body);
			
			response.setUserId(savedUser.getUserId());
			response.setUsername(savedUser.getUserName());
			response.setEmail(savedUser.getEmail());
			response.setMessage("OTP Send Successfully..");
		}
		
		return response;
	}
	
	public String verifyUser(String email, String otp) {
		String response = "";
		User user = userRepo.findByEmail(email);
		
		if(user != null && user.isVerified()) {
			response = "User Already verified..";
		} else if(otp.equals(user.getOtp())) {
			user.setVerified(true);
			userRepo.save(user);
			response = "User Verified..";
		} else {
			response = "User Not verified..";
		}
		
		return response;
	}
	
	public String generateBody(String userName, String otp) {
		String res = "Hi " + userName +
				""" 
				~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				Welcome to My Email OTP Service...
				~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				----------------------------------
				Your OTP is : 
				""" + otp;
		return res;
	}
}
