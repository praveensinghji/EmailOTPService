package com.email.otp.emailOTPVerification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.otp.emailOTPVerification.entity.EmailOtpVerification;
import com.email.otp.emailOTPVerification.payload.RequestDto;
import com.email.otp.emailOTPVerification.payload.ResponseDto;
import com.email.otp.emailOTPVerification.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/userRegistration")
	public ResponseEntity<ResponseDto> userRegistration(@RequestBody RequestDto request){
		ResponseDto response = userService.registerUser(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/userVerify")
	public ResponseEntity<?> userVarification(@RequestBody EmailOtpVerification responce){
		String response = userService.verifyUser(responce.getEmail(), responce.getOtp());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
