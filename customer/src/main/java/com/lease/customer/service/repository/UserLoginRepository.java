package com.lease.customer.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lease.customer.dto.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long>{

	public UserLogin findByUsername(String username);
	
}
