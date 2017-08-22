package com.capgemini.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.AgencyDao;
import com.capgemini.dao.CarDao;
import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.WorkerEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AgencyDaoTest {
	
	@Autowired
	AgencyDao agencyDao;
	
	@Autowired
	WorkerDao workerDao;
	
	@Autowired 
	CarDao carDao;
	 
	@Test
	public void testShouldAddWorkerToAgency() {
		
		//given
		WorkerEntity workerToAdd = workerDao.findOne(81L);
		AgencyEntity agencyEntity = agencyDao.findOne(7L);
		int workersSizeBefore = agencyEntity.getWorkers().size();
		//when
		agencyDao.addWorkerToAgency(agencyEntity.getId(), workerToAdd);
		int workersSizeAfter = agencyEntity.getWorkers().size();
		//then
		assertEquals(workersSizeAfter, workersSizeBefore + 1);
	}
	
	@Test
	public void testShouldDeleteWorkerFromAgency() {
		
		//given
		AgencyEntity agencyEntity = agencyDao.findOne(6L);
		int workersSizeBefore = agencyEntity.getWorkers().size();
		//when
		agencyDao.deleteWorkerFromAgency(agencyEntity.getId(), workerDao.findOne(10L));
		int workersSizeAfter = agencyEntity.getWorkers().size();
		//then
		assertEquals(workersSizeAfter, workersSizeBefore - 1);
	}
	
	@Test
	public void testShouldFindAllWorkers(){
		
		//given
		AgencyEntity agencyEntity = agencyDao.findOne(6L);
		//when
		List <WorkerEntity> list = agencyDao.findAllWorkers(agencyEntity.getId());
		//then 
		assertEquals(7, list.size());
	}

	@Test
	public void testShouldUpdateAgency(){
		
		//given
		AgencyEntity agencyEntity = agencyDao.findOne(10L);
		agencyEntity.setEmail("agency@xxx.com");
		//when
		agencyDao.update(agencyEntity);
		//then
		assertEquals("agency@xxx.com", agencyDao.findOne(10L).getEmail());
	}  
	
	@Test
	public void testShouldDeleteAgency(){
		
		//given
		AgencyEntity agencyEntity = agencyDao.findOne(15L);
		//when
		agencyDao.delete(15L);
		//then
		assertNotNull(agencyEntity);
		assertNull(agencyDao.findOne(15L));
	}
	
	@Test
	public void testShouldFindWorkerByAgencyAndCar() {
		
		//given
		AgencyEntity agency = agencyDao.findOne(10L);
		CarEntity car = carDao.findOne(7L);
		Long id = null;
		///when
		Set<WorkerEntity> worker = agencyDao.findWorkers(agency, car);

		for (WorkerEntity w : worker) {
			id = w.getId();
		}
		//then
		assertTrue(id.equals(4L));
	}
	
}
