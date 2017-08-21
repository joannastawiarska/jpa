package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.RentDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.RentEntity;
import com.capgemini.service.RentService;

@Service
@Transactional(readOnly=true)
public class RentServiceImpl implements RentService {
	
	@Autowired
    private RentDao rentRepository;
	
	@Override
	public RentEntity save(RentEntity rentEntity){
		return rentRepository.save(rentEntity);
	}
	
	@Override
	public List<RentEntity> findAll(){
		return rentRepository.findAll();
	}
	
	@Override
	public RentEntity findOne(Long id){
		return rentRepository.findOne(id);
	}
}
