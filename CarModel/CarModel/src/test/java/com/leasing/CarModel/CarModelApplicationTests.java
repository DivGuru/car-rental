package com.leasing.CarModel;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.leasing.CarModel.Contoller.CarController;

@SpringBootTest
class CarModelApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertThat(CarController.class).isNotNull();
	}

}
