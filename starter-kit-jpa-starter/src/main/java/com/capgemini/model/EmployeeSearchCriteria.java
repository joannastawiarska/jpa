package com.capgemini.model;

public class EmployeeSearchCriteria {

	Long agencyId;
	Long carId;
	Long positionId;
	
	public Long getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(Long branchId) {
		this.agencyId = branchId;
	}
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public Long getPositionId() {
		return positionId;
	}
	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}
	
}
