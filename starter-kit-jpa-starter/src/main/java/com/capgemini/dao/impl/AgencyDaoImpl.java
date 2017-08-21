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
	public void addWorkerToAgency(Long agencyId, WorkerEntity worker) {
		
		AgencyEntity agency = findOne(agencyId);
		List<WorkerEntity> workers = agency.getWorkers();
		workers.add(worker);
		agency.setWorkers(workers);
		entityManager.merge(agency);
	}

	@Override
	public void deleteWorkerFromAgency(Long agencyId, WorkerEntity worker) {
		
		AgencyEntity agency = findOne(agencyId);
		List<WorkerEntity> workers = agency.getWorkers();
		workers.remove(worker);
		agency.setWorkers(workers);
		entityManager.merge(agency);
	}

	@Override
	public List<WorkerEntity> findAllWorkers(Long agencyId) {
		
		AgencyEntity agency = findOne(agencyId);
		return agency.getWorkers();
	}

	@Override
	public List<WorkerEntity> findWorkers(Long agencyId, Long carId) {
		// TODO Auto-generated method stub
		return null;
	}

}
