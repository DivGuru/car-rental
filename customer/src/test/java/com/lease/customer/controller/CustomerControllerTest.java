package com.lease.customer.controller;

import com.lease.customer.config.SecurityConfig;
import com.lease.customer.dto.Customer;
import com.lease.customer.service.CustomerService;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
//@Import(value = SecurityConfig.class)
//@SpringBootTest
@WebMvcTest(value = CustomerController.class)
//@Import(SecurityConfig.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    @WithMockUser("authuser")
    public void retrieveCustomerDetailsWithmockUser() throws Exception {

        Customer mockCustomer = new Customer(100,"Jack","123 street","Chennai","97865","jack@abc.com","1234567654");
        Mockito.when(customerService.getCustomerById(100)).thenReturn(mockCustomer);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/{id}",100)
                .accept(MediaType.ALL);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")).andExpect(jsonPath("$.name").value("Jack"))
                .andReturn();

        System.out.println("Result : "+mvcResult.getResponse().getContentAsString());

        //Verify service is called once
        Mockito.verify(customerService,Mockito.times(1)).getCustomerById(100);

    }

    @Test
    @WithMockUser(authorities = "SCOPE_ADMIN")
    public void getCustomerDetailsWithAdminRole() throws Exception {
        Customer mockCustomer = new Customer(100,"Jack","123 street","Chennai","97865","jack@abc.com","1234567654");
        Mockito.when(customerService.getCustomerById(100)).thenReturn(mockCustomer);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/{id}",100)
               // .with(SecurityMockMvcRequestPostProcessors.jwt().authorities(new SimpleGrantedAuthority("SCOPE_USER")))
                .accept(MediaType.ALL);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();

        System.out.println("Result json : "+mvcResult.getResponse().getContentAsString());

    }

}
