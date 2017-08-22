package com.capgemini.dao;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.WorkerEntity;

public interface CarDao extends Dao<CarEntity, Long>{

	CarEntity updateCarer(Set<WorkerEntity> workers, Long carId);
	
	List<CarEntity> findByMakeAndType(String make, String type);
	
	Set<CarEntity> findByCarer(WorkerEntity carerId);
	
	List<CarEntity> getCarsRentMoreThanSix();
	
	Long findCarsRentedOnDate(Date firstDate, Date secondDate);
	
}
