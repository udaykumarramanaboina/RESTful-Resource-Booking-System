package com.company.booking.service;

import com.company.booking.dto.LoginRequest;
import com.company.booking.dto.SignupRequest;

public interface AuthService {
	void signup(SignupRequest request);
	String login(LoginRequest request);
}
