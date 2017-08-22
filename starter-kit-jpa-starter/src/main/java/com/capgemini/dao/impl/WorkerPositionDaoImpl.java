package com.capgemini.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.WorkerPositionDao;
import com.capgemini.domain.WorkerPositionEntity;

@Transactional(Transactional.TxType.SUPPORTS)
@Repository
public class WorkerPositionDaoImpl extends AbstractDao<WorkerPositionEntity, Long> implements WorkerPositionDao {

}
