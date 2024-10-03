package com.leasing.CarModel.DAO;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.leasing.CarModel.EntityDTO.CarDTO;
import com.leasing.CarModel.Repository.CarDTORepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {
	
	@Autowired
	CarDTORepository carDTORepository;
	
	@Test
	public void testCreateandDelete() {
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
		
		carDTORepository.save(car);
		Iterable<CarDTO> cars=carDTORepository.findAll();
		Assertions.assertThat(cars).extracting(CarDTO :: getCarMake).containsOnly("Tesla");
		
		carDTORepository.deleteAll();
		Assertions.assertThat(carDTORepository.findAll()).isEmpty();
	}
	
	@Test
	public void testFindById() {
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
		
		CarDTO savedCar = carDTORepository.save(car);

		Long savedCarId = savedCar.getCarId();

        Optional<CarDTO> cars = carDTORepository.findById(savedCarId);
        assertTrue(cars.isPresent());
	    Assertions.assertThat(cars.get().getCarMake()).isEqualTo("Tesla");
	    carDTORepository.deleteAll();
		Assertions.assertThat(carDTORepository.findAll()).isEmpty();
	}
	
}
