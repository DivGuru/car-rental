package com.lease.customer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lease.customer.dto.CarDTO;

@FeignClient(name="carModel",configuration = com.lease.customer.config.FeignClientConfig.class)
public interface CarClient {

    @GetMapping("Car/{id}")
    ResponseEntity<CarDTO> getCarById(@PathVariable("id") Long id);

    @PostMapping("Car/Submit")
    String SubmitNewCar(@RequestBody CarDTO carDTO);

//    @PutMapping("Car/add")
//    CarDTO updateCarDetails(CarDTO carDTO);

    @DeleteMapping("Car/return/{id}")
    String DeleteCar(@PathVariable Long id);
}
