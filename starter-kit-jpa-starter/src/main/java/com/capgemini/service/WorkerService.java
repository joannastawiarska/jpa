package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.WorkerEntity;

public interface WorkerService {

	List<WorkerEntity> findWorkersAgency(AgencyEntity agency);
	WorkerEntity save(WorkerEntity worker);
}
