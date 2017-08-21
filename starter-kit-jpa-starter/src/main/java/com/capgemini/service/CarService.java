package com.capgemini.service;

import java.util.List;
import java.util.Set;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.WorkerEntity;

public interface CarService {

	CarEntity updateCarer(Set<WorkerEntity> workers, Long carId);
	
	List<CarEntity> findByMakeAndType(String make, String type);
	
	Set<CarEntity> findByCarer(WorkerEntity worker);	
	
	CarEntity save(CarEntity carEntity);
	
	CarEntity update(CarEntity carEntity);
	
	void delete(CarEntity carEntity);

	List<CarEntity> findAll();
	
	CarEntity findOne(Long id);
	
}
