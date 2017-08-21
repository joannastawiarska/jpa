package com.capgemini.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.RentEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DeleteChildRowTest {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private RentService rentService;
	
	private CarEntity car;
	private RentEntity rentFirst;
	private RentEntity rentSecond;
	
	@Before
	public void setUp(){	
		
		car = new CarEntity("Mercedes", "A", "black", 2000, 300, 3004, 40000);	
		Set<RentEntity> rents = new HashSet<RentEntity>();
		rentFirst = new RentEntity(new Date(),new Date(),50);
		rentSecond = new RentEntity(new Date(),new Date(),100);
		
		rentService.save(rentFirst);
		rentService.save(rentSecond);	
		
		rents.add(rentFirst);
		rents.add(rentSecond);
		car.setRents(rents);
		
		carService.save(car);		
	}

	@Test
	public void testShouldRemoveChildRowsOfCar() {
		
        //given
		assertNotNull(rentService.findOne(rentFirst.getId()));
		assertNotNull(rentService.findOne(rentSecond.getId()));
		
		//when
		carService.delete(car);
		
		//then
		assertNull(rentService.findOne(rentFirst.getId()));
		assertNull(rentService.findOne(rentSecond.getId()));
	}

}
