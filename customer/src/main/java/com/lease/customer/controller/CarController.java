package com.lease.customer.controller;

import com.lease.customer.client.CarClient;
import com.lease.customer.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Car")
public class CarController {

    @Autowired
    CarClient carClient;

  /*  @PostMapping("/Submit")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public String SubmitNewCar(@RequestBody CarDTO carDTO) throws Exception {
        return carService.SubmitNewCar(carDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public String DeleteCar(@PathVariable Long id) throws Exception {
        return carService.DeleteCar(id);*/
}
