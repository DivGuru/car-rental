package com.lease.customer.repository;

import com.lease.customer.dto.Customer;
import com.lease.customer.service.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer(500,"customer","abc street","Dublin","98765","cust@gmail.com","987654321");
        Customer savedCustomer = customerRepository.save(customer);

        System.out.println("Customer is "+savedCustomer);

        Assertions.assertNotNull(savedCustomer);
        Assertions.assertEquals(savedCustomer.getName(),"customer");
    }

    @Test
    public void testGetCustomerByName(){
        Customer customer = new Customer(500,"customer","abc street","Dublin","98765","cust@gmail.com","987654321");
        customerRepository.save(customer);

        List<Customer> savedCustomer = customerRepository.findByName("customer");

        Assertions.assertNotNull(savedCustomer.get(0));
        Assertions.assertEquals(savedCustomer.get(0).getName(),"customer");

    }
}
