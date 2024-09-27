package com.lease.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lease.customer.dto.Customer;
import com.lease.customer.service.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer getCustomerById(long id) throws Exception {

			
		Optional<Customer> customerOptional =  customerRepository.findById(id);

		Customer customer = customerOptional.orElseThrow(()->new Exception("Not found customer with id "+id));
		return customer;

	}
	
	
	public List<Customer> getCustomerByName(String name) {
		return customerRepository.findByName(name);
	}


	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}


	public void deleteCustomer(long id) throws Exception {
		 customerRepository.findById(id).orElseThrow(()->new Exception("Not found customer with id "+id));
		 customerRepository.deleteById(id);
	}


	public List<Customer> findByName(String username) {
		return customerRepository.findByName(username);
		
	}

}
