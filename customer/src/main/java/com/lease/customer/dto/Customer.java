package com.lease.customer.dto;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;	
	private String street;
	private String city;
	private String zipcode;	
	private String email;
	private String phone;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference("customerReference")
	private List<Role> roles = new ArrayList<Role>();
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Customer(long id, String name, String street, String city, String zipcode, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.email = email;
		this.phone = phone;
	}
	
	
	public Customer() {
		
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", street=" + street + ", city=" + city + ", zipcode="
				+ zipcode + ", email=" + email + ", phone=" + phone + ", roles=" + roles + "]";
	}
	
	
	
	

}
