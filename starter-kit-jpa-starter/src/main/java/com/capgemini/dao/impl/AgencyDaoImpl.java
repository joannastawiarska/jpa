 package com.capgemini.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.AgencyDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.CarEntity;
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
	public Set<WorkerEntity> findWorkers(AgencyEntity agency, CarEntity car) {

		TypedQuery<WorkerEntity> query = entityManager.createQuery(
				"select worker from WorkerEntity worker where :agency = worker.agency and :car MEMBER OF worker.car",
				WorkerEntity.class);
		query.setParameter("agency", agency);
		query.setParameter("car", car);

		return new HashSet<WorkerEntity>(query.getResultList());

	}

}
