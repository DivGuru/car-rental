package com.Leasing.lease.contoller;

import java.time.LocalDateTime;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.Leasing.lease.Controllers.LeaseController;
import com.Leasing.lease.Entity.LeaseDTO;
import com.Leasing.lease.Entity.Status;
import com.Leasing.lease.Service.LeaseService;
import com.Leasing.lease.Service.SecurityConfig;
import com.Leasing.lease.Util.JWTTokenUtil;

@WebMvcTest(LeaseController.class)
@Import(SecurityConfig.class)
public class ControllerTest {
	
	@MockBean
	LeaseService leaseService;
	

	@MockBean
	JWTTokenUtil jwtTokenUtil;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testGetLeaseByIdWithWrongAuth() throws Exception {
		LeaseDTO lease=new LeaseDTO();
		lease.setLeaseId(12345L);
		lease.setUserId(12345L);
        lease.setCarId(67890L);
        lease.setTotalAmount(35000.50);
        lease.setLeaseStartDateTime(LocalDateTime.of(2024, 10, 1, 10, 0));
        lease.setLeaseEndDate(LocalDateTime.of(2027, 10, 1, 10, 0));
        lease.setLeaseInterestRate(4.25);
        lease.setStatus(Status.STARTED);
        
        Mockito.when(leaseService.getLease(12345L)).thenReturn(ResponseEntity.ok(lease));
        mockMvc.perform(MockMvcRequestBuilders.get("/lease/12345").with(SecurityMockMvcRequestPostProcessors.jwt().authorities(new SimpleGrantedAuthority("SCOPE_USER")))
        		.contentType(MediaType.ALL))
        		.andExpect(MockMvcResultMatchers.status().isOk())
        		.andExpect(MockMvcResultMatchers.jsonPath("$.userId", Matchers.is(12345)));
        
        
	}
	
	@Test
	public void testGetLeaseByIdWithRightAuth() throws Exception {
		LeaseDTO lease=new LeaseDTO();
		lease.setLeaseId(12345L);
		lease.setUserId(12345L);
        lease.setCarId(67890L);
        lease.setTotalAmount(35000.50);
        lease.setLeaseStartDateTime(LocalDateTime.of(2024, 10, 1, 10, 0));
        lease.setLeaseEndDate(LocalDateTime.of(2027, 10, 1, 10, 0));
        lease.setLeaseInterestRate(4.25);
        lease.setStatus(Status.STARTED);
        
        Mockito.when(leaseService.getLease(12345L)).thenReturn(ResponseEntity.ok(lease));
        mockMvc.perform(MockMvcRequestBuilders.get("/lease/12345").with(SecurityMockMvcRequestPostProcessors.jwt().authorities(new SimpleGrantedAuthority("SCOPE_ADMN")))
        		.contentType(MediaType.ALL))
        		.andExpect(MockMvcResultMatchers.status().is(403));
	}
	
}
