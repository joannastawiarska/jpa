package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.service.WorkerService;

@Service
@Transactional(readOnly=true)
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	WorkerDao workerDao;
	
	@Override
	public List<WorkerEntity> findWorkersAgency(AgencyEntity agency){
		return workerDao.findWorkersAgency(agency);
	}
	
	@Override
	public WorkerEntity save(WorkerEntity worker){
		return workerDao.save(worker);
	}
	
}
