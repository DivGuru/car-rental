package com.Leasing.lease.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Leasing.lease.Entity.LeaseDTO;
import com.Leasing.lease.Repository.LeaseDTORepository;

@RestController
@RequestMapping("/lease")
public class LeaseController {

	
	
	
	public ResponseEntity<LeaseDTO> getLease(@PathVariable Long id){
		return null;
	}
	
	public ResponseEntity<LeaseDTO> AddLease(@RequestBody LeaseDTO leaseDTO){
		return null;
	}
	
	public ResponseEntity<LeaseDTO> GetAmount(@PathVariable Long id){
		return null;
	}
}
