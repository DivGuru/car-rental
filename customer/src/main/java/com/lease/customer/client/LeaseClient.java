package com.lease.customer.client;

import com.lease.customer.dto.LeaseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "leaseModel", configuration = com.lease.customer.config.FeignClientConfig.class)
public interface LeaseClient {

    @GetMapping("/lease/{id}")
    ResponseEntity<LeaseDTO> getLease(@PathVariable("id") Long id);
}
