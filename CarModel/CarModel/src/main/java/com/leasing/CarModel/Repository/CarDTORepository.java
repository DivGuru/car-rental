package com.leasing.CarModel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leasing.CarModel.EntityDTO.CarDTO;

public interface CarDTORepository extends JpaRepository<CarDTO, Long>{

}
