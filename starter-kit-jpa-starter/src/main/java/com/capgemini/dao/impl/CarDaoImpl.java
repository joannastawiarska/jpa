package com.capgemini.dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
                "select car from CarEntity car where car.make like :make and car.type like :type", CarEntity.class);
        query.setParameter("make", make);
        query.setParameter("type", type);
        return query.getResultList();
        
	}
	
	//wyszukaj po opiekunie
	@Override
	public List<CarEntity> findByCarer(Long carerId){
		
		TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car, CARER carer where carer.id = :carerId", CarEntity.class);
        query.setParameter("carerId", carerId);
        return query.getResultList();
	} 
	

	public CarEntity updateCarer(Set<WorkerEntity> workers, Long carId){
			
		CarEntity car = findOne(carId);
		car.setWorkers(workers);
		return entityManager.merge(car);
		
	  }
		
	}
	
	
