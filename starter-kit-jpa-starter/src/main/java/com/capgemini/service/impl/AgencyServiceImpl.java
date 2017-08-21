package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.AgencyDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.service.AgencyService;

@Service
@Transactional(readOnly=true)
public class AgencyServiceImpl implements AgencyService {

	
	@Autowired
    private AgencyDao agencyRepository;
	
	@Override
	public AgencyEntity save(AgencyEntity agencyEntity){
		return agencyRepository.save(agencyEntity);
	}
	
	@Override
	public AgencyEntity update(AgencyEntity agencyEntity){
		return agencyRepository.update(agencyEntity);
	}
	
	@Override
	public void delete(AgencyEntity agencyEntity){
		agencyRepository.delete(agencyEntity);
	}
	
	@Override
	public void addWorkerToAgency(Long agencyId, WorkerEntity worker){
		agencyRepository.addWorkerToAgency(agencyId, worker);
	}

	@Override
	public void deleteWorkerFromAgency(Long agencyId, WorkerEntity worker){
		agencyRepository.deleteWorkerFromAgency(agencyId, worker);
	}

	@Override
	public List<WorkerEntity> findAllWorkers(Long agencyId){
		return agencyRepository.findAllWorkers(agencyId);
	}

	@Override
	public List<WorkerEntity> findWorkers(Long agencyId, Long carId){
		return agencyRepository.findWorkers(agencyId, carId);
	}
	
	@Override
	public List<AgencyEntity> findAll(){
		return agencyRepository.findAll();
	}
	
	@Override
	public AgencyEntity findOne(Long id){
		return agencyRepository.findOne(id);
	}
}
