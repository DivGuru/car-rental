package com.leasing.CarModel.EntityDTO;

import java.time.LocalDateTime;

public class ReturnDTO {
	
	private LocalDateTime returnEndTime;
	
	private double returnDistance;
	
	public ReturnDTO() {
		super();
	}

	public ReturnDTO(LocalDateTime returnEndTime, double returnDistance) {
		super();
		this.returnEndTime = returnEndTime;
		this.returnDistance = returnDistance;
	}

	public LocalDateTime getReturnEndTime() {
		return returnEndTime;
	}

	public void setReturnEndTime(LocalDateTime returnEndTime) {
		this.returnEndTime = returnEndTime;
	}

	public double getReturnDistance() {
		return returnDistance;
	}

	public void setReturnDistance(double returnDistance) {
		this.returnDistance = returnDistance;
	}
	
	
}
