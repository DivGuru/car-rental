package com.lease.customer.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lease.customer.dto.UserLogin;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	private UserLoginService userLoginService;

	public CustomerUserDetailsService(UserLoginService service) {
		super();
		this.userLoginService = service;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin user = userLoginService.getUserByName(username);
		
		
		return new User(
                user.getUsername(),
                user.getPassword(),
                Arrays.stream(new String[]{"USER"})
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())
        );
		
	//	return null;
	}
	
	
	
	
}
