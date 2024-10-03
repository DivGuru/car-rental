package com.leasing.CarModel.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.leasing.CarModel.EntityDTO.CarDTO;
import com.leasing.CarModel.Repository.CarDTORepository;
import com.leasing.CarModel.Service.CarService;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
	
	@InjectMocks
	CarService carService;
	
	@Mock
	CarDTORepository carDTORepository;
	
	private CarDTO car;
	
	private CarDTO car1;
	
	@BeforeEach
	public void init() {
		car = new CarDTO();
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
		
		
		car1 = new CarDTO();
		car1.setCarId(889L);
		car1.setCarMake("Tesla");
		car1.setCarModel("Model S");
		car1.setCarVersion("Plaid");
		car1.setCarType("Electric");
		car1.setCarMileage("10000 miles");
		car1.setCarCo2Emission("0 g/km");
		car1.setCarGrossPrice("90000 USD");
		car1.setCarNettPrice("85000 USD");
		car1.setCarDoors(4);
		car1.setCarDistance(500.0);
		car1.setCarIsAvailable(true);
	}
	
	@Test
	public void GetCarById() {
		BDDMockito.given(carDTORepository.save(car)).willReturn(car);
		try {
			String savedCar=carService.SubmitNewCar(car);
			assertThat(savedCar).isEqualTo("Submitted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
