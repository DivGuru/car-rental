package com.lease.customer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lease.customer.dto.Customer;
import com.lease.customer.dto.Role;
import com.lease.customer.dto.UserLogin;
import com.lease.customer.service.repository.CustomerRepository;
import com.lease.customer.service.repository.RoleRepository;
import com.lease.customer.service.repository.UserLoginRepository;

import jakarta.transaction.Transactional;

@Service
public class RoleService {
	
	private final UserLoginRepository userLoginRepository;
	
	private final RoleRepository roleRepository;
	
	


	public RoleService(RoleRepository roleRepository, UserLoginRepository userLoginRepository) {
		super();
		this.roleRepository = roleRepository;
		this.userLoginRepository = userLoginRepository;
	}

	@Transactional
	public ResponseEntity<UserLogin> AddRoleToUser(Long id, Role role) {
		try {
			Role newRole = roleRepository.save(role);
			UserLogin userLogin=userLoginRepository.findById(id).orElseThrow(()->new RuntimeException("User NOT FOUND"));
			Customer customer=userLogin.getCustomer();
			customer.getRoles().add(newRole);
			return ResponseEntity.ok(userLogin);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
