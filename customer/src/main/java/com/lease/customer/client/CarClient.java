package com.lease.customer.client;

import com.lease.customer.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="carModel",configuration = com.lease.customer.config.FeignClientConfig.class)
public interface CarClient {

    @GetMapping("Car/{id}")
    CarDTO getCarById(@PathVariable("id") Long id);

    @PostMapping("Car/Submit")
    CarDTO addNewCarDetails(@RequestBody CarDTO carDTO);

    @PutMapping("Car/add")
    CarDTO updateCarDetails(CarDTO carDTO);

    @DeleteMapping("Car/{id}")
    String deleteCar(@PathVariable Long id);
}
