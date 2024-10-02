package com.lease.customer.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.lease.customer.config.SecurityConfig;
import com.lease.customer.dto.Customer;
import com.lease.customer.dto.Role;
import com.lease.customer.dto.UserRoles;
import com.lease.customer.service.CustomerService;
import com.lease.customer.service.CustomerUserDetailsService;

@ExtendWith(SpringExtension.class)
@Import(SecurityConfig.class)
//@SpringBootTest
@WebMvcTest(value = CustomerController.class)
//@ContextConfiguration(classes = CustomerApplication.class)
//@Import(SecurityConfig.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @MockBean
    CustomerUserDetailsService customerUserDetailsService;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Test
    @WithMockUser
    public void retrieveCustomerDetailsWithmockUser() throws Exception {

        Customer mockCustomer = new Customer(100,"Jack","123 street","Chennai","97865","jack@abc.com","1234567654");
        Mockito.when(customerService.getCustomerById(100)).thenReturn(mockCustomer);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/{id}",100)
                .with(SecurityMockMvcRequestPostProcessors.jwt().authorities(new SimpleGrantedAuthority("SCOPE_USER")))
                .accept(MediaType.ALL);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().contentType("application/json")).andExpect(jsonPath("$.name").value("Jack"))
                .andReturn();

        System.out.println("Result : "+mvcResult.getResponse().getContentAsString());

        //Verify service is called once
        Mockito.verify(customerService,Mockito.times(1)).getCustomerById(100);

    }

     @Test
  // @WithMockUser(authorities = "SCOPE_USER")
    public void getCustomerDetailsWithAdminRole() throws Exception {
        Customer mockCustomer = new Customer(100,"Jack","123 street","Chennai","97865","jack@abc.com","1234567654");
        Role role = new Role();
        role.setRoleId(20);
        role.setRole(UserRoles.ADMIN);
        mockCustomer.setRoles(Arrays.asList(role));
        Mockito.when(customerService.getCustomerById(100)).thenReturn(mockCustomer);


        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/{id}",100)
                .with(SecurityMockMvcRequestPostProcessors.jwt().authorities(new SimpleGrantedAuthority("SCOPE_ADMIN")))
                .accept(MediaType.ALL);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        System.out.println("Result json : "+mvcResult.getResponse().getContentAsString());

    }

}
