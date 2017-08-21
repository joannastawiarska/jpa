package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.RentEntity;

public interface RentService {

	public RentEntity save(RentEntity rentEntity);
	
	public List<RentEntity> findAll();
	
	public RentEntity findOne(Long id);
}
