package com.capgemini.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.QCarEntity;
import com.capgemini.domain.QWorkerEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.model.EmployeeSearchCriteria;
import com.querydsl.jpa.impl.JPAQuery;

@Transactional(Transactional.TxType.SUPPORTS)
@Repository
public class WorkerDaoImpl extends AbstractDao<WorkerEntity, Long> implements WorkerDao {
	
	//@SuppressWarnings("unchecked")
	//@Override
	//public List<WorkerEntity> findWorkAgency(AgencyEntity agency){
	//	
	//	String jpql = "SELECT worker FROM WorkerEntity worker WHERE agency = :agency";
	//	Query query = entityManager.createQuery(jpql, WorkerEntity.class)
	//	                           .setParameter("agency", agency);
	//	
	//	return (List<WorkerEntity>)query.getSingleResult();
	//
	//}

   public List<WorkerEntity> searchWorkersByCriteria(EmployeeSearchCriteria criteria){
	   
	   QWorkerEntity worker = QWorkerEntity.workerEntity;
	   QCarEntity car = QCarEntity.carEntity;
	   JPAQuery<WorkerEntity> query = new JPAQuery<WorkerEntity>(entityManager).from(worker);
	   
	   if (criteria.getCarId() != null){
		   JPAQuery<CarEntity> carQuery = new JPAQuery<CarEntity>(entityManager).from(car).where(car.id.eq(criteria.getCarId()));
		   query = query.where(worker.car.contains(carQuery.fetchOne()));
	   }
	   if (criteria.getAgencyId() != null) {
		   query = query.where(worker.agency.id.eq(criteria.getAgencyId()));
	   }
	   if (criteria.getPositionId() != null){
		   query = query.where(worker.position.id.eq(criteria.getPositionId()));
	   }
	   
	   return query.fetch();
   }

}
