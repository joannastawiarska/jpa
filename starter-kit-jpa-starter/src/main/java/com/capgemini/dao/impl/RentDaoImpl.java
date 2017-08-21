package com.capgemini.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.RentDao;
import com.capgemini.domain.RentEntity;

@Transactional(Transactional.TxType.SUPPORTS)
@Repository
public class RentDaoImpl extends AbstractDao<RentEntity, Long> implements RentDao {

}
