package com.capgemini.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.WorkerEntity;

@Transactional(Transactional.TxType.SUPPORTS)
@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao{
	
	@Override
	public List<CarEntity> findByMakeAndType(String make, String type){
		
		TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where make = :make and type = :type", CarEntity.class);
        query.setParameter("make", make);
        query.setParameter("type", type);
        return query.getResultList();  
	}
	
	
	@Override
	public Set<CarEntity> findByCarer(WorkerEntity worker){
		
		//TypedQuery<CarEntity> query = entityManager.createQuery(
               // "select c from WorkerEntity as w join w.car as c where w.id = :id", CarEntity.class);
		TypedQuery<CarEntity> query = entityManager.createQuery(
        "select car from CarEntity car where :worker MEMBER OF car.worker", CarEntity.class);
        //query.setParameter("id", worker.getId());
		query.setParameter("worker", worker);
        return new HashSet<CarEntity>(query.getResultList());
        
	} 
	
	@Override
	public CarEntity updateCarer(Set<WorkerEntity> workers, Long carId){	
		
		CarEntity car = findOne(carId);
		car.setWorker(workers);
		return entityManager.merge(car);

	  }
		
	}
	
	
