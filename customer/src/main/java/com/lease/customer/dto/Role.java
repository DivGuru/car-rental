package com.lease.customer.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roleId;
	
	@ManyToOne
	@JoinColumn(name="id")
	@JsonBackReference("customerReference")
	private Customer customer;
	
	private UserRoles role;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public UserRoles getRole() {
		return role;
	}

	public void setRole(UserRoles role) {
		this.role = role;
	}

	public Role(long roleId, Customer customer, UserRoles role) {
		super();
		this.roleId = roleId;
		this.customer = customer;
		this.role = role;
	}
	
	public Role() {
		
	}
	
}
