package com.Leasing.lease.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class LeaseDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leaseId;
	
	private Long userId;
	
	private Long carId;
	
	private double totalAmount;
	
	private LocalDateTime leaseStartDateTime;
	
	private LocalDateTime leaseEndDate;
	
	private Double leaseInterestRate;
	
	private Status status;
	
	public LeaseDTO() {
		super();
	}

	public LeaseDTO(Long leaseId, Long userId, Long carId, double totalAmount, LocalDateTime leaseStartDateTime,
			LocalDateTime leaseEndDate, Double leaseInterestRate, Status status) {
		super();
		this.leaseId = leaseId;
		this.userId = userId;
		this.carId = carId;
		this.totalAmount = totalAmount;
		this.leaseStartDateTime = leaseStartDateTime;
		this.leaseEndDate = leaseEndDate;
		this.leaseInterestRate = leaseInterestRate;
		this.status = status;
	}

	public Long getLeaseId() {
		return leaseId;
	}

	public void setLeaseId(Long leaseId) {
		this.leaseId = leaseId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getLeaseStartDateTime() {
		return leaseStartDateTime;
	}

	public void setLeaseStartDateTime(LocalDateTime leaseStartDateTime) {
		this.leaseStartDateTime = leaseStartDateTime;
	}

	public LocalDateTime getLeaseEndDate() {
		return leaseEndDate;
	}

	public void setLeaseEndDate(LocalDateTime leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}

	public Double getLeaseInterestRate() {
		return leaseInterestRate;
	}

	public void setLeaseInterestRate(Double leaseInterestRate) {
		this.leaseInterestRate = leaseInterestRate;
	}

	public Status isStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	

}
