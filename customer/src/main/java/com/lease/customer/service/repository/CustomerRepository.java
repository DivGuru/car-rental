package com.lease.customer.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lease.customer.dto.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	//public Customer findById(long id);
	
	public List<Customer> findByName(String name);

}
