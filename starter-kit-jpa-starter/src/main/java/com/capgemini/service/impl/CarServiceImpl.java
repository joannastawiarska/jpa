package com.capgemini.service.impl;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.service.CarService;

@Service
@Transactional(readOnly=true)
public class CarServiceImpl implements CarService {

	@Autowired
    private CarDao carRepository;
	
	@Override
	public CarEntity save(CarEntity carEntity){
		return carRepository.save(carEntity);
	}
	
	@Override
	public CarEntity update(CarEntity carEntity){
		return carRepository.update(carEntity);
	}
	
	@Override
	public void delete(CarEntity carEntity){
		carRepository.delete(carEntity);
	}
	
	@Override
	public CarEntity updateCarer(Set<WorkerEntity> workers, Long carId){
		return carRepository.updateCarer(workers, carId);
	}
	
	@Override
	public List<CarEntity> findByMakeAndType(String make, String type){
		return carRepository.findByMakeAndType(make, type);
	}
	
	@Override
	public Set<CarEntity> findByCarer(WorkerEntity worker){
		return carRepository.findByCarer(worker);
	}
	
	@Override
	public List<CarEntity> findAll(){
		return carRepository.findAll();
	}
	
	@Override
	public CarEntity findOne(Long id){
		return carRepository.findOne(id);
	}
	
}
