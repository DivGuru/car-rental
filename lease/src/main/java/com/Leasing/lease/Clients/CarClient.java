package com.Leasing.lease.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(name = "carModels", configuration = com.Leasing.lease.Config.FeignClientConfig.class)
public interface CarClient {

    @GetMapping("/Car/{id}")
    CarDTO getCarById(@PathVariable("id") Long id);
    
   
	@PutMapping("Car/book/{id}")
	String UpdateAvailability(@PathVariable("id") Long id);
}
