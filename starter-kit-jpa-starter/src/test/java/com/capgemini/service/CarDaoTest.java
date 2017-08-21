package com.capgemini.service;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
	
	private CarEntity carEntity;
	
	
	@Before
	public void setUp(){
		carEntity = new CarEntity("Mercedes", "A", "black", 2000, 300, 3004, 40000);
		carDao.save(carEntity);
	}
	
	@Test
	public void testDatabaseShouldNotBeEmpty(){
		List<CarEntity> cars;
		cars = carDao.findAll();
		assertTrue(0 != cars.size());
		
	}
	
	@Test
	public void testShouldFindByCarerr(){
		Set<CarEntity> cars;
		//given
		WorkerEntity worker = workerDao.findOne(3L);
		System.out.println(worker.getName()+ "aaaaaaaaaaaaaaaaaaaaaaa");
		//when
		cars = carDao.findByCarer(worker);
		//then
		for(CarEntity car:cars)
		         System.out.println(car.getId()+ "             " + car.getProductionYear()+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		assertEquals(2, cars.size());
		
	}
	
	@Test
	public void testShouldFindByMakeAndType(){
		List<CarEntity> cars;
		//given
		String make = "Lexus";
		String type = "GS";
		//when
		 cars = carDao.findByMakeAndType(make, type);
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
	
	 @Ignore
	 @Test
	 public void testShouldUpdateCar(){
		 List<CarEntity> cars;
		 //given
		 CarEntity lastCar = getLastCar();
		 lastCar.setColor("funnyPinky");
		 lastCar.setMileage(200000);
		 
		 //when 
		 carDao.update(lastCar);
		 
		 //then
		 cars = carDao.findAll();
		 assertEquals("funnyPinky", cars.get(cars.size()-1).getColor());
		 assertEquals((int)200000,(int)cars.get(cars.size()-1).getMileage()); 
	 }
	 
	 @Test
	  public void testShouldDeleteLastCar(){
		 //given
		 CarEntity lastCar = getLastCar();
		 long lastIndex = lastCar.getId();
		 
		 //when
		 carDao.delete(lastCar);
		 
		 //then
		 assertNull(carDao.findOne(lastIndex));
	 }
	 
	 @Test
	 public void testShouldUpdateCarerOfCar(){
		 //given
		 WorkerEntity worker = new WorkerEntity("William","Hills",null);
		 workerDao.save(worker);
		
		 Set<WorkerEntity> carers = new HashSet<WorkerEntity>();
		 carers.add(worker);
		 
		 //when
		 carDao.updateCarer(carers, carEntity.getId());
		 
		 //then
		 assertTrue(carEntity.getWorker().contains(worker));
		 assertTrue(1 == carEntity.getWorker().size());
	 }
	 
	 private CarEntity getLastCar(){
		 List<CarEntity> cars;
		 cars = carDao.findAll();
		 return cars.get(cars.size()-1);		 
	 }
	 
	 @Test 
	 public void testShouldIncrementEntityVersion(){
		 //given
		 CarEntity lastCar = getLastCar();
		 long version = lastCar.getVersion();
		 
		 //when
		 lastCar.setColor("newColor");
		 carDao.update(lastCar);
		 
		 //then
		 assertEquals(version + 1, getLastCar().getVersion());
	 }
	 
	 @Test
	 public void testShouldSetCorrectCreationDate(){
		 
		 //given
		 LocalDateTime now = LocalDateTime.now();
		 
		 //then
		 validateCreationDate(getLastCarCreationDate(), now);
	 }
	 
	 @Test
	 public void testShouldUpdateDate(){
		 
		 //given
		 CarEntity lastCar = getLastCar();
		 LocalDateTime now = LocalDateTime.now();
		 
		 //when
		 lastCar.setMake("Opel");
		 carDao.update(lastCar);
		 
		 //then
		 validateCreationDate(getLastCarUpdateDate(), now);
		 assertTrue(0 != getLastCarCreationDate().compareTo(getLastCarUpdateDate()));
		 
	 }
	 
	 private LocalDateTime getLastCarCreationDate(){
		 return getLastCar().getEntityDateCreate().toLocalDateTime();
	 }
	 
	 private LocalDateTime getLastCarUpdateDate(){
		 return getLastCar().getEntityDateUpdate().toLocalDateTime();
	 }
	 
	 private void validateCreationDate(LocalDateTime creationDate, LocalDateTime nowDate){
		 assertEquals(creationDate.getYear(),nowDate.getYear());
		 assertEquals(creationDate.getMonth(),nowDate.getMonth());
		 assertEquals(creationDate.getDayOfMonth(),nowDate.getDayOfMonth());
		 assertEquals(creationDate.getHour(),nowDate.getHour());
		 assertEquals(creationDate.getSecond(),nowDate.getSecond());
	 }
}
