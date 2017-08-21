package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.WorkerEntity;

public interface WorkerDao extends Dao<WorkerEntity, Long> {
	
	List<WorkerEntity> findWorkersAgency(AgencyEntity agency);
}
