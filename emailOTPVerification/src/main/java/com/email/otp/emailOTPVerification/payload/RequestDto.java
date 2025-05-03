package com.email.otp.emailOTPVerification.payload;

import lombok.Data;

@Data
public class RequestDto {
	private String userName;
	private String email;
	
	
	public RequestDto() {
		super();
	}
	
	public RequestDto(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RequestDto [userName=" + userName + ", email=" + email + "]";
	}
	
	
}
