package com.Leasing.lease.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Leasing.lease.Entity.LeaseDTO;
import com.Leasing.lease.Repository.LeaseDTORepository;
import com.Leasing.lease.Service.LeaseService;

@RestController
@RequestMapping("/lease")
public class LeaseController {
	
	@Autowired
	private LeaseService leaseService;
	
	@GetMapping("/")
	public ResponseEntity<String> getLease() throws Exception{
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LeaseDTO> getLease(@PathVariable Long id) throws Exception{
		return leaseService.getLease(id);
	}
	
	@PostMapping("/Submit")
	public ResponseEntity<LeaseDTO> AddLease(@RequestBody LeaseDTO leaseDTO) throws Exception{
		return leaseService.AddLease(leaseDTO);
	}
	
	public ResponseEntity<LeaseDTO> GetAmount(@PathVariable Long id){
		return null;
	}
}
