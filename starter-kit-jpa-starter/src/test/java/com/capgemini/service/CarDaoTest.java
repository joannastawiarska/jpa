package com.capgemini.service;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.CarDao;
import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.WorkerEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CarDaoTest {

	@Autowired
	private CarDao carDao;
	
	@Autowired
	private WorkerDao workerDao;

	@Autowired
	EntityManager entityManager;
	
	@Test
	public void testDatabaseShouldNotBeEmpty(){
		carDao.findAll();
	}
	@Test
	public void testShouldgetCarsRentMoreThanThree(){
		
		//given
		CarEntity carEntity = carDao.findOne(17L);
		//when
		List<CarEntity> result = carDao.getCarsRentMoreThanSix();
		//then
		assertTrue(result.contains(carEntity));
	}

	
	@Test
	public void testShouldFindByCarer(){
		
		//given
		WorkerEntity worker = workerDao.findOne(3L);
		//when
		Set<CarEntity> cars = carDao.findByCarer(worker);
		//then
		assertEquals(2, cars.size());
		assertTrue(cars.contains(carDao.findOne(78L)));
		assertTrue(cars.contains(carDao.findOne(96L)));
	}
	
	@Test
	public void testShouldFindByMakeAndType(){

		//given
		String make = "Lexus";
		String type = "GS";
		//when
		List<CarEntity> cars = carDao.findByMakeAndType(make, type);
		//then
		assertNotNull(cars);
		assertEquals("Lexus", cars.get(0).getMake());
		assertEquals("GS", cars.get(0).getType());
	}
	
	@Test
	public void testShouldTestSaveCar(){
		
		//given
		CarEntity carEnt = new CarEntity("Mercedes", "S", "silver", 2000, 300, 3004, 40000);
		int sizeExpected = (carDao.findAll()).size() + 1;
		//when
		carDao.save(carEnt);
		int sizeActual = carDao.findAll().size();
		
		//then
		assertEquals(sizeExpected, sizeActual);
		
	}
	 
	 @Test
	  public void testShouldDeleteLastCar(){
		 
		 //given
		 CarEntity car = carDao.findOne(20L);
		 //when
		 carDao.delete(car);
		 //then
		 assertNull(carDao.findOne(20L));
	 }
	 
	 @Test
	 public void testShouldUpdateCarerOfCar(){
		 
		 //given
		 WorkerEntity worker = workerDao.findOne(9L);
		 CarEntity car = carDao.findOne(15L);
		 Set<WorkerEntity> carers = carDao.findOne(15L).getWorker();
		 carers.add(worker);
		 //when
		 carDao.updateCarer(carers, car.getId());
		 //then
		 assertTrue(carDao.findOne(15L).getWorker().contains(worker));
		 assertEquals(3, carDao.findOne(15L).getWorker().size());
	 }
	 
	 @Test(expected = ObjectOptimisticLockingFailureException.class)
	 public void testShouldIncrementEntityVersion(){
		 
		//given
		CarEntity car = carDao.findOne(1L);
		CarEntity carTwo = carDao.findOne(1L);
		car.setProductionYear(1995);
		carTwo.setProductionYear(2000);
		//when
		entityManager.detach(car);
		entityManager.detach(carTwo);
		//then
		carDao.update(car);
		entityManager.flush();
		carDao.update(carTwo);
	 }
	 
	 @Test
	 public void shouldReturnAmountOfCarsWithRentDateBetween() {

		//when
		long amount = carDao.findCarsRentedOnDate(Date.valueOf("2017-01-05"), Date.valueOf("2017-12-01"));
		//then
		assertEquals(11L, amount);
	}
	 
	 @Test
	 public void testShouldSetCorrectCreationDate(){
		 
		 //given
		 LocalDateTime now = LocalDateTime.now();
		 CarEntity createCar = new CarEntity("Opel", "Astra", "silver", 3000, 3000, 2004, 40000);
		 //when
		 carDao.save(createCar);
		 
		 //then
		 validateCreationDate(getCreationDate(createCar), now);
	 }
	 
	 @Test
	 public void testShouldUpdateDate(){
		 
		 //given
		 CarEntity carEntity = new CarEntity("Mazda", "A", "black", 2000, 300, 3004, 40000); 
		 carDao.save(carEntity);
		 LocalDateTime now = LocalDateTime.now();
		 //when
		 carEntity.setMake("Opel");
		 CarEntity carEntityy = carDao.update(carEntity);
		 carDao.findAll();
		 //then
		 validateCreationDate(getUpdateDate(carEntity), now);
		 assertTrue(0 != getCreationDate(carEntity).compareTo(getUpdateDate(carEntityy)));
		 
	 }
	 
	 private LocalDateTime getCreationDate(CarEntity car){
		 return car.getEntityDateCreate().toLocalDateTime();
	 }
	 
	 private LocalDateTime getUpdateDate(CarEntity car){
		 return car.getEntityDateUpdate().toLocalDateTime();
	 }
	 
	 private void validateCreationDate(LocalDateTime creationDate, LocalDateTime nowDate){
		 assertEquals(creationDate.getYear(),nowDate.getYear());
		 assertEquals(creationDate.getMonth(),nowDate.getMonth());
		 assertEquals(creationDate.getDayOfMonth(),nowDate.getDayOfMonth());
		 assertEquals(creationDate.getHour(),nowDate.getHour());
		 assertEquals(creationDate.getSecond(),nowDate.getSecond());
	 }
	
}
