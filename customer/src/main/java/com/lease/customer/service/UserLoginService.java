package com.lease.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lease.customer.dto.UserLogin;
import com.lease.customer.service.repository.UserLoginRepository;

@Service
public class UserLoginService {
	
	private final static Logger log = LoggerFactory.getLogger(UserLoginService.class);
	
	@Autowired
	private UserLoginRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public UserLogin getUserByName(String username) {
		return repository.findByUsername(username);
	}

	public UserLogin signUpUser(UserLogin user) {
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		UserLogin login = repository.save(user);
		
		log.debug("Saved user with id {}",user.getUserId());
		return login;
		//
	}
}
