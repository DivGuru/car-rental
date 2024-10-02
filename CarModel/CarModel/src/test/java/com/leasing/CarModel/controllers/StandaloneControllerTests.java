package com.leasing.CarModel.controllers;

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

import com.leasing.CarModel.Contoller.CarController;
import com.leasing.CarModel.EntityDTO.CarDTO;
import com.leasing.CarModel.Security.SecurityConfig;
import com.leasing.CarModel.Service.CarService;

@WebMvcTest(CarController.class)
@Import(SecurityConfig.class) 
public class StandaloneControllerTests {
		
		
	@MockBean
	CarService carService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testGetCarByIdWithWrongAuthority() throws Exception{
		CarDTO car = new CarDTO();
		car.setCarId(888L);
		car.setCarMake("Tesla");
		car.setCarModel("Model S");
		car.setCarVersion("Plaid");
		car.setCarType("Electric");
		car.setCarMileage("10000 miles");
		car.setCarCo2Emission("0 g/km");
		car.setCarGrossPrice("90000 USD");
		car.setCarNettPrice("85000 USD");
		car.setCarDoors(4);
		car.setCarDistance(500.0);
		car.setCarIsAvailable(true);
		
		Mockito.when(carService.GetCarById(888L)).thenReturn(ResponseEntity.ok(car));
		mockMvc.perform(MockMvcRequestBuilders.get("/Car/888").with(SecurityMockMvcRequestPostProcessors.jwt()
				.authorities(new SimpleGrantedAuthority("SCOPE_ADMI")))
                .contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(403));
		//.andExpect(MockMvcResultMatchers.jsonPath("$.carMake",Matchers.is("Tesla")));
	}
	
	@Test
	public void testGetCarByIdWithAuthorityAsAdmin() throws Exception{
		CarDTO car = new CarDTO();
		car.setCarId(888L);
		car.setCarMake("Tesla");
		car.setCarModel("Model S");
		car.setCarVersion("Plaid");
		car.setCarType("Electric");
		car.setCarMileage("10000 miles");
		car.setCarCo2Emission("0 g/km");
		car.setCarGrossPrice("90000 USD");
		car.setCarNettPrice("85000 USD");
		car.setCarDoors(4);
		car.setCarDistance(500.0);
		car.setCarIsAvailable(true);
		//System.out.println("Success");
		Mockito.when(carService.GetCarById(888L)).thenReturn(ResponseEntity.ok(car));
		mockMvc.perform(MockMvcRequestBuilders.get("/Car/888").with(SecurityMockMvcRequestPostProcessors.jwt()
				.authorities(new SimpleGrantedAuthority("SCOPE_ADMIN")))
                .contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.carMake",Matchers.is("Tesla")));
	}
	
}
