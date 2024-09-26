package com.Leasing.lease.Service;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Leasing.lease.Entity.LeaseDTO;
import com.Leasing.lease.Entity.Status;
import com.Leasing.lease.Repository.LeaseDTORepository;

@Service
public class LeaseService {
	
	private final LeaseDTORepository leaseDTORepository;

	public LeaseService(LeaseDTORepository leaseDTORepository) {
		super();
		this.leaseDTORepository = leaseDTORepository;
	}
	
	public ResponseEntity<LeaseDTO> getLease(Long id) throws Exception{
		try {
			LeaseDTO lease= leaseDTORepository.findById(id).orElseThrow(()-> new RuntimeException("Lease Date Not Found"));
			return ResponseEntity.ok(lease);
		}catch(Exception e) {
			throw new Exception(e);
		}
	}
	
	public String AddLease(LeaseDTO lease) throws Exception{
		try {
	        // Set the status based on the lease start and end dates
	        LocalDateTime now = LocalDateTime.now();
	        
	        if (lease.getLeaseStartDateTime().isAfter(now)) {
	            lease.setStatus(Status.NOTSTARTED);
	        } else if (lease.getLeaseEndDate().isBefore(now)) {
	            lease.setStatus(Status.CONCLUDED);
	        } else {
	            lease.setStatus(Status.STARTED);
	        }
	        LeaseDTO savedLease = leaseDTORepository.save(lease);
	        return "Added Successfully";
	    } catch (Exception e) {
	        throw new Exception(e);
	    }
	}
	
	
	
	
	
	
	
}
