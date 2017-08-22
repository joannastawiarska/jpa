package com.capgemini.service;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.CarDao;
import com.capgemini.dao.RentDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.RentEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DeleteChildRowTest {
	
	@Autowired
	private CarDao carDao;
	
	@Autowired
	private RentDao rentDao;
		
	@Test
	public void testShouldRemoveOneChildRowsOfCar() {
        
		//given
		RentEntity rent = rentDao.findOne(3L);
		CarEntity car = carDao.findOne(86L);
		//when
		carDao.delete(car);
		//then
		assertNull(rentDao.findOne(3L));
		assertNotNull(rent);
	}
	
	@Test
	public void testShouldRemoveTwoChildRowsOfCar() {
		
        //given
		RentEntity rentFirst = rentDao.findOne(9L);
		RentEntity rentSecond = rentDao.findOne(61L);
		CarEntity car = carDao.findOne(8L);
		//when
		carDao.delete(car);
		//then
		assertNotNull(rentFirst);
		assertNotNull(rentSecond);
		assertNull(rentDao.findOne(9L));
		assertNull(rentDao.findOne(61L));
	}

}
