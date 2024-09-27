package com.leasing.CarModel.EntityDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class CarDTO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carId;
	
	private String carMake;
	
	private String carModel;
	
	private String carVersion;
	
	private String carType;
	
	private String carMileage;
	
	private String carCo2Emission;
	
	private String carGrossPrice;
	
	private String CarNettPrice;
	
	private int carDoors;
	
	private double carDistance;
	
	private boolean carIsAvailable;
	
	
	public CarDTO() {
		
	}

	
	
	public CarDTO(Long carId, String carMake, String carModel, String carVersion, String carType, String carMileage,
			String carCo2Emission, String carGrossPrice, String carNettPrice, int carDoors, double carDistance,
			boolean carIsAvailable) {
		super();
		this.carId = carId;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carVersion = carVersion;
		this.carType = carType;
		this.carMileage = carMileage;
		this.carCo2Emission = carCo2Emission;
		this.carGrossPrice = carGrossPrice;
		CarNettPrice = carNettPrice;
		this.carDoors = carDoors;
		this.carDistance = carDistance;
		this.carIsAvailable = carIsAvailable;
	}



	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarVersion() {
		return carVersion;
	}

	public void setCarVersion(String carVersion) {
		this.carVersion = carVersion;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarMileage() {
		return carMileage;
	}

	public void setCarMileage(String carMileage) {
		this.carMileage = carMileage;
	}

	public String getCarCo2Emission() {
		return carCo2Emission;
	}

	public void setCarCo2Emission(String carCo2Emission) {
		this.carCo2Emission = carCo2Emission;
	}

	public String getCarGrossPrice() {
		return carGrossPrice;
	}

	public void setCarGrossPrice(String carGrossPrice) {
		this.carGrossPrice = carGrossPrice;
	}

	public String getCarNettPrice() {
		return CarNettPrice;
	}

	public void setCarNettPrice(String carNettPrice) {
		CarNettPrice = carNettPrice;
	}

	public int getCarDoors() {
		return carDoors;
	}

	public void setCarDoors(int carDoors) {
		this.carDoors = carDoors;
	}

	public double getCarDistance() {
		return carDistance;
	}

	public void setCarDistance(double carDistance) {
		this.carDistance = carDistance;
	}

	public boolean isCarIsAvailable() {
		return carIsAvailable;
	}

	public void setCarIsAvailable(boolean carIsAvailable) {
		this.carIsAvailable = carIsAvailable;
	}
	
	
	
	
	

}
