package com.Leasing.lease.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Leasing.lease.Entity.LeaseDTO;
import com.Leasing.lease.Entity.ReturnDTO;
import com.Leasing.lease.Service.LeaseService;
import com.Leasing.lease.Util.JWTTokenUtil;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/lease")
public class LeaseController {

    @Autowired
    private LeaseService leaseService;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @GetMapping("/")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<String> getLease() throws Exception {
        jwtTokenUtil.printTokenDetails(); // Print the token details
        return ResponseEntity.ok("Success");
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<LeaseDTO> getLease(@PathVariable Long id) throws Exception {
        return leaseService.getLease(id);
    }

    @PostMapping("/Submit")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<LeaseDTO> AddLease(@RequestBody LeaseDTO leaseDTO) throws Exception {
    	System.out.println("Inside Post");
        return leaseService.AddLease(leaseDTO);
    }
    
    @PostMapping("/return/{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<String> ReturnCar(@PathVariable Long id, @RequestBody ReturnDTO returnDto) throws Exception{
    	System.out.println(returnDto.getReturnDistance());
    	return leaseService.ReturnCar(id, returnDto);
    }
    
}
