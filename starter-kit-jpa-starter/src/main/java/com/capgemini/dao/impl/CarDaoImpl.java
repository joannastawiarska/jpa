package com.capgemini.dao.impl;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.QCarEntity;
import com.capgemini.domain.QRentEntity;
import com.capgemini.domain.RentEntity;
import com.capgemini.domain.WorkerEntity;
import com.querydsl.jpa.impl.JPAQuery;

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
		
		TypedQuery<CarEntity> query = entityManager.createQuery(
				"select car from CarEntity car where :worker MEMBER OF car.worker", CarEntity.class);
		query.setParameter("worker", worker);
        return new HashSet<CarEntity>(query.getResultList());   
	} 
	
	@Override
	public CarEntity updateCarer(Set<WorkerEntity> workers, Long carId){	
		
		CarEntity car = findOne(carId);
		car.setWorker(workers);
		return entityManager.merge(car);
	  }
	
	@Override
	public List<CarEntity> getCarsRentMoreThanSix(){
		
		QCarEntity car = QCarEntity.carEntity;
		JPAQuery<CarEntity> query = new JPAQuery<CarEntity>(entityManager).from(car);
		return query.from(car).where(car.rents.size().gt(6)).fetch();
		
	}
	
	@Override
	public Long findCarsRentedOnDate(Date firstDate, Date secondDate) {

		QRentEntity rent = QRentEntity.rentEntity;
		JPAQuery<RentEntity> query = new JPAQuery<RentEntity>(entityManager).from(rent);
		long amount = query.where(rent.dateRent.before(secondDate).and(rent.dateRent.after(firstDate))).fetchCount();
		return amount;
	}
}
	
	
