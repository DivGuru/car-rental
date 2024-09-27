package com.Leasing.lease.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "carModels") // The name should match the spring.application.name of the Car microservice
public interface CarClient {

    @GetMapping("/Car/{id}")
    CarDTO getCarById(@PathVariable("id") Long id);
}
