package com.email.otp.emailOTPVerification.payload;

import lombok.Data;

@Data
public class ResponseDto {
	private Long userId;
	private String username;
	private String email;
	private boolean verified;
	private String message;
	
	public ResponseDto() {
		super();
	}
	
	public ResponseDto(Long userId, String username, String email, boolean verified, String message) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.verified = verified;
		this.message = message;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
