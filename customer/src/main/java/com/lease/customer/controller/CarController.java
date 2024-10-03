package com.lease.customer.controller;

import com.lease.customer.client.CarClient;
import com.lease.customer.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Car")
public class CarController {

    @Autowired
    CarClient carClient;

    @PostMapping("/Submit")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<String> SubmitNewCar(@RequestBody CarDTO carDTO) throws Exception {
         carClient.addNewCarDetails(carDTO);
         return ResponseEntity.ok("Added the car");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<String> DeleteCar(@PathVariable Long id) throws Exception {
         carClient.deleteCar(id);
         return ResponseEntity.ok("Deleted the car with id "+id);
    }
}
