package com.leasing.CarModel.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leasing.CarModel.EntityDTO.CarDTO;
import com.leasing.CarModel.EntityDTO.ReturnDTO;
import com.leasing.CarModel.Repository.CarDTORepository;

import jakarta.transaction.Transactional;

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
			//System.out.println(nc.getCarId());
			return "Submitted Successfully";
		}catch (Exception e) {
			throw new Exception(e);
		}
		
		
	}
	
	public String DeleteCar(Long id) throws Exception {
		try {
			carDTORepository.deleteById(id);
		}catch(Exception e) {
			throw new Exception(e);
		}
		return "Deleted Successfully";
	}

	@Transactional
	public String UpdateAvailability(Long id) throws Exception {
		try {
			System.out.println("In here avail");
			CarDTO carDTO=carDTORepository.findById(id).orElseThrow(() -> new RuntimeException("NO Car Found"));
			carDTO.setCarIsAvailable(false);
			return "Success";
		}catch (Exception e) {
			throw new Exception(e);
		}
		
	}

	@Transactional
	public String UpdateReturnedCar(Long id, ReturnDTO returnDto) throws Exception {
		try {
			System.out.println(returnDto.getReturnDistance());
			CarDTO carDTO=carDTORepository.findById(id).orElseThrow(() -> new RuntimeException("NO Car Found"));
			carDTO.setCarIsAvailable(true);
			carDTO.setCarDistance(returnDto.getReturnDistance());
			return "Success";
		}catch (Exception e) {
			throw new Exception(e);
		}
	}
	
}
