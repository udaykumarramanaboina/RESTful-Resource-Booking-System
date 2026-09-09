package com.company.booking.service.impl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.booking.dto.LoginRequest;
import com.company.booking.dto.SignupRequest;
import com.company.booking.entity.UserEntity;
import com.company.booking.enums.Role;
import com.company.booking.repository.UserRepository;
import com.company.booking.service.AuthService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	public void signup(SignupRequest request) {
		boolean isEmailExists= userRepository.existsByEmail(request.getEmail());
		if(isEmailExists) {
			throw new IllegalArgumentException("Invalid email or email already exists");
		}
		String hashedPassword = passwordEncoder.encode(request.getPassword());
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(request.getEmail());
		userEntity.setPassword(hashedPassword);
		userEntity.setRole(Role.USER);
		userRepository.save(userEntity);
		log.info("User registered successfully with email: {}", request.getEmail());
	}
	@Override
	public String login(LoginRequest request) {
		// Implement login logic here
		return "";
	}

}
