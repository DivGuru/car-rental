package com.lease.customer.client;

import com.lease.customer.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="carModel",configuration = com.lease.customer.config.FeignClientConfig.class)
public interface CarClient {

    @GetMapping("/Car/{id}")
    CarDTO getCarById(@PathVariable("id") Long id);

    @PostMapping("/Car/add")
    CarDTO addNewCarDetails(CarDTO carDTO);

    @PutMapping("/Car/add")
    CarDTO updateCarDetails(CarDTO carDTO);

   // CarDTO deleteCar(Car)
}
