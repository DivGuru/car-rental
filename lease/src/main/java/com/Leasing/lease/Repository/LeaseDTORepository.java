package com.Leasing.lease.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Leasing.lease.Entity.LeaseDTO;

public interface LeaseDTORepository extends JpaRepository<LeaseDTO, Long> {
	
	

}
