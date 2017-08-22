package com.capgemini.dao;

import java.util.List;
import java.util.Set;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.WorkerEntity;

public interface AgencyDao extends Dao<AgencyEntity, Long> {

	void addWorkerToAgency(Long agencyId, WorkerEntity worker);

	void deleteWorkerFromAgency(Long agencyId, WorkerEntity worker);

	List<WorkerEntity> findAllWorkers(Long agencyId);

	Set<WorkerEntity> findWorkers(AgencyEntity agency, CarEntity car);

}
