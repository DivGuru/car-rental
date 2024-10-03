package com.lease.customer.controller;

import com.lease.customer.client.LeaseClient;
import com.lease.customer.dto.LeaseDTO;
import com.lease.customer.dto.ReturnDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lease")
public class LeaseController {

    @Autowired
    LeaseClient leaseClient;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<LeaseDTO> getLease(@PathVariable Long id) throws Exception {
        return leaseClient.getLease(id);
    }

    @PostMapping("/Submit")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<LeaseDTO> AddLease(@RequestBody LeaseDTO leaseDTO) throws Exception {
        System.out.println("Submitting lease details ");
        return leaseClient.AddLease(leaseDTO);
    }

    @PostMapping("/return/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<String> ReturnCar(@PathVariable Long id, @RequestBody ReturnDTO returnDto) throws Exception{
       // System.out.println(""returnDto.getReturnDistance());
        return leaseClient.ReturnCar(id, returnDto);
    }
}
