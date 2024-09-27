package com.leasing.CarModel.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leasing.CarModel.EntityDTO.CarDTO;
import com.leasing.CarModel.Repository.CarDTORepository;

@Service
public class CarService {
	
	private final CarDTORepository carDTORepository;

	public CarService(CarDTORepository carDTORepository) {
		super();
		this.carDTORepository = carDTORepository;
	}
	
	
	public ResponseEntity<CarDTO> GetCarById(Long id){
		CarDTO Car=carDTORepository.findById(id).orElseThrow(() -> new RuntimeException("Car Not FOund"));
		return ResponseEntity.ok(Car);
	}
	
	public String SubmitNewCar(CarDTO carDTO) throws Exception {
		try {
			CarDTO nc= carDTORepository.save(carDTO);
			System.out.println(nc.getCarId());
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		return "Submitted Successfully";
	}
	
	public String DeleteCar(Long id) throws Exception {
		try {
			carDTORepository.deleteById(id);
		}catch(Exception e) {
			throw new Exception(e);
		}
		return "Deleted Successfully";
	}
	
}