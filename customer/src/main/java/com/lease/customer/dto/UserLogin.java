package com.lease.customer.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class UserLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	
	private String username;
	
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid", referencedColumnName = "id")
	private Customer customer;
	
	public UserLogin() {
		
	}

	public UserLogin(long userId, String username, String password, Customer customer) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.customer = customer;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", username=" + username + ", password=" + password + ", customer="
				+ customer + "]";
	}
	
	

}
