package com.capgemini.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.AgencyDao;
import com.capgemini.dao.CarDao;
import com.capgemini.dao.WorkerDao;
import com.capgemini.dao.WorkerPositionDao;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.model.EmployeeSearchCriteria;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WorkerDaoTest {
	
	@Autowired
	AgencyDao agencyDao;
	
	@Autowired
	WorkerDao workerDao;
	
	@Autowired 
	CarDao carDao;
	
	@Autowired
	WorkerPositionDao workerPosition;

     @Test 
     public void testSearchWorkersByOneCriteria(){
    	 
    	 //given
    	 EmployeeSearchCriteria criteria = new EmployeeSearchCriteria();
    	 criteria.setAgencyId(1L);
    	 //when
    	 List<WorkerEntity> workers =  workerDao.searchWorkersByCriteria(criteria);
    	 //then
    	 //agencja id = 1 ma pieciu pracownikow
    	 assertEquals(5, workers.size());
    	 
     }
     
     @Test
     public void testSearchWorkersByTwoCriteria(){
    	 
    	 //given
    	 WorkerEntity worker = workerDao.findOne(20L);
    	 EmployeeSearchCriteria criteria = new EmployeeSearchCriteria();
    	 criteria.setAgencyId(1L);
    	 criteria.setCarId(17L);
    	 //when
    	 List<WorkerEntity> workers =  workerDao.searchWorkersByCriteria(criteria);
    	 //then
    	 //pracownik z id = 20 pracuje w agencji id = 1 i opiekuje sie samochodem id = 17
    	 assertEquals(1, workers.size());
    	 assertEquals(worker, workers.get(0));
    	 
     }
     
     @Test
     public void testSearchWorkersByThreeCriteria(){
    	 
    	 //given
    	 WorkerEntity worker = workerDao.findOne(5L);
    	 EmployeeSearchCriteria criteria = new EmployeeSearchCriteria();
    	 criteria.setAgencyId(6L);
    	 criteria.setCarId(36L);
    	 criteria.setPositionId(3L);
    	 //when
    	 List<WorkerEntity> workers =  workerDao.searchWorkersByCriteria(criteria);
    	 //then
    	 //pracownik z id = 5 pracuje w placowce id = 6, opiekuje sie samochodem id = 36, pracuje na pozycji 3 (accountant)
    	 assertEquals(1, workers.size());
    	 assertEquals(worker, workers.get(0));
     }
     
     @Test
     public void testSearchWorkersByAgency(){
    	 
    	 //given
    	 EmployeeSearchCriteria criteria = new EmployeeSearchCriteria();
    	 criteria.setAgencyId(10L);
    	 //when
    	 List<WorkerEntity> workers =  workerDao.searchWorkersByCriteria(criteria);
    	 //w placowce id = 10 pracuja 3 osoby
    	 //then
    	 assertEquals(3, workers.size());
    	 assertTrue(workers.contains(workerDao.findOne(4L)));
    	 assertTrue(workers.contains(workerDao.findOne(84L)));
    	 assertTrue(workers.contains(workerDao.findOne(95L)));
     }
     
     @Test
     public void testSearchWorkersByCar(){
    	 
    	 //given
    	 WorkerEntity worker = workerDao.findOne(20L);
    	 EmployeeSearchCriteria criteria = new EmployeeSearchCriteria();
    	 criteria.setAgencyId(1L);
    	 criteria.setCarId(17L);
    	 //when
    	 List<WorkerEntity> workers =  workerDao.searchWorkersByCriteria(criteria);
    	 //then
    	 //pracownik z id = 20 pracuje w agencji id = 1 i opiekuje sie samochodem id = 17
    	 assertEquals(1, workers.size());
    	 assertEquals(worker, workers.get(0)); 
     }
     
     @Test
     public void testSearchWorkersByPosition(){
    	 
    	 //given
    	 EmployeeSearchCriteria criteria = new EmployeeSearchCriteria();
    	 criteria.setPositionId(3L);
    	 //when
    	 List<WorkerEntity> workers =  workerDao.searchWorkersByCriteria(criteria);
    	 //then
    	 //pracownik z id = 20 pracuje w agencji id = 1 i opiekuje sie samochodem id = 17
    	 assertEquals(36, workers.size());
     }
     
  }
