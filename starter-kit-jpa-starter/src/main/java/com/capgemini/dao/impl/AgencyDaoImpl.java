 package com.capgemini.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.AgencyDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.WorkerEntity;

@Transactional(Transactional.TxType.SUPPORTS)
@Repository
public class AgencyDaoImpl extends AbstractDao<AgencyEntity, Long> implements AgencyDao{

	@Override
	public void addWorker(Long workerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWorker(Long workerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<WorkerEntity> findAllWorkers(Long agencyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WorkerEntity> findWorkers(Long agencyId, Long carId) {
		// TODO Auto-generated method stub
		return null;
	}

}
