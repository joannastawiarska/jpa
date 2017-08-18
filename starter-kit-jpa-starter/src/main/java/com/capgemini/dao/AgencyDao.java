package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.WorkerEntity;

public interface AgencyDao extends Dao<AgencyEntity, Long> {

	void addWorker(Long workerId);

	void deleteWorker(Long workerId);

	List<WorkerEntity> findAllWorkers(Long agencyId);

	List<WorkerEntity> findWorkers(Long agencyId, Long carId); // pracownicy
																// opiekujacy
																// sie danym
																// samochodem
																// pracujacy w
																// danej
																// placowce

}
