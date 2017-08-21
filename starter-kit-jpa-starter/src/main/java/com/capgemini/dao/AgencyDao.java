package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.WorkerEntity;

public interface AgencyDao extends Dao<AgencyEntity, Long> {

	void addWorkerToAgency(Long agencyId, WorkerEntity worker);

	void deleteWorkerFromAgency(Long agencyId, WorkerEntity worker);

	List<WorkerEntity> findAllWorkers(Long agencyId);

	List<WorkerEntity> findWorkers(Long agencyId, Long carId);

}
