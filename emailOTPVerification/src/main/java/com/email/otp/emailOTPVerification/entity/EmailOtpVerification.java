package com.email.otp.emailOTPVerification.entity;

public class EmailOtpVerification {
	private String email;
	private String otp;
	public EmailOtpVerification() {
		super();
	}
	public EmailOtpVerification(String email, String otp) {
		super();
		this.email = email;
		this.otp = otp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "EmailOtpVerification [email=" + email + ", otp=" + otp + "]";
	}
	
	
}
