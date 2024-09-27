package com.leasing.CarModel.Contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leasing.CarModel.EntityDTO.CarDTO;
import com.leasing.CarModel.Service.CarService;

@RestController
@RequestMapping("/Car")
public class CarController {
	
	
	public final CarService carService;
	
	

	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}

	@GetMapping(path="/")
	@PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
	public String Welcome() {
		return "Hello World - This is Car";
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
	public ResponseEntity<CarDTO> GetCarById(@PathVariable Long id){
		return carService.GetCarById(id);
	}
	
	@PostMapping("/Submit")
	@PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
	public String SubmitNewCar(@RequestBody CarDTO carDTO) throws Exception {
		return carService.SubmitNewCar(carDTO);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
	public String DeleteCar(@PathVariable Long id) throws Exception {
		return carService.DeleteCar(id);
	}
	
	
	
	
	

}
