package com.lease.customer.client;

import com.lease.customer.dto.LeaseDTO;
import com.lease.customer.dto.ReturnDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "leaseModel", configuration = com.lease.customer.config.FeignClientConfig.class)
public interface LeaseClient {

    @GetMapping("/{id}")
    public ResponseEntity<LeaseDTO> getLease(@PathVariable Long id);

    @PostMapping("/Submit")
    public ResponseEntity<LeaseDTO> AddLease(@RequestBody LeaseDTO leaseDTO);

    @PostMapping("/return/{id}")
    public ResponseEntity<String> ReturnCar(@PathVariable Long id, @RequestBody ReturnDTO returnDto);
    
}
