package com.email.otp.emailOTPVerification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.email.otp.emailOTPVerification.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

	public User findByEmail(String email);

}
