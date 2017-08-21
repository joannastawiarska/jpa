package com.capgemini.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.QWorkerEntity;
import com.capgemini.domain.WorkerEntity;
import com.querydsl.jpa.impl.JPAQuery;

@Transactional(Transactional.TxType.SUPPORTS)
@Repository
public class WorkerDaoImpl extends AbstractDao<WorkerEntity, Long> implements WorkerDao {
	
	@Override
	public List<WorkerEntity> findWorkersAgency(AgencyEntity agency){
		
		String jpql = "SELECT worker FROM WorkerEntity worker WHERE agency = :agency";
		Query query = entityManager.createQuery(jpql, WorkerEntity.class)
		                           .setParameter("agency", agency);
		
		List<WorkerEntity> workers = (List<WorkerEntity>) query.getSingleResult();
		
		
		/*CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<WorkerEntity> query = cb.createQuery(WorkerEntity.class);
		Root<WorkerEntity> workerEntity = query.from(WorkerEntity.class);
		query.multiselect( workerEntity.get("agency").alias("agency"))
		
		     .where(cb.equal( workerEntity.get("agency"), agency));
		TypedQuery<WorkerEntity> tq = entityManager.createQuery(query);
		 
		for (WorkerEntity t : tq.getResultList()) {
		   workers.add(t);
		}*/
		
		return workers;
	}
	
	public List<WorkerEntity> findByBranchAndCar(Long branchId, Long carId){
       QWorkerEntity empl = QWorkerEntity.workerEntity;              
        JPAQuery<WorkerEntity> query = new JPAQuery<WorkerEntity>(entityManager).from(empl);
        List<WorkerEntity> workers = query.where(empl.agency.id.eq(branchId)).fetch();
        return workers;
   };


}
