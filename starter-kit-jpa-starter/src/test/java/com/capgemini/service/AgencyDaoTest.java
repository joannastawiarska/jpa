package com.capgemini.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.dao.AgencyDao;
import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.domain.WorkerPositionEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AgencyDaoTest {
	
	@Autowired
	AgencyDao agencyDao;
	
	@Autowired
	WorkerDao workerDao;

	private List<WorkerEntity> workers = new ArrayList<WorkerEntity>();
	private WorkerEntity worker;
	private WorkerEntity worker2;
	private AgencyEntity agencyEntity;
	
	@Before
	public void setUp(){
		
		//worker = new WorkerEntity("John", "Doe", new WorkerPositionEntity("seller"));
		//worker2 = new WorkerEntity("Alice", "Smith", new WorkerPositionEntity("manager"));
		///workerDao.save(worker);
		//workerDao.save(worker2);
		//workers.add(worker);
		//workers.add(worker2);
		
		//agencyEntity = new AgencyEntity("34454545", "agency@ccc.com", workers);
		//agencyDao.save(agencyEntity);
	}
	
	 //@After
	 //public void tearDown() throws Exception {
		// agencyDao.delete(agencyEntity); 
	//}
	 
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
		System.out.println(agencyEntity.getId() + "aaaaaaaaaaaaaaaaaaaaaaaaaa");
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
		//agencyService.update(agencyEntity);
		//then
		assertEquals("agency@xxx.com", agencyDao.findOne(agencyEntity.getId()).getEmail());
		
	}
	
	//@Test
	//public void test() {
//
	//	List<WorkerEntity> workersActual = workerDao.findWorkersAgency(agencyEntity);
	//	
	//	assertTrue(workersActual.contains(worker));
	//	assertTrue(workersActual.contains(worker2));
	//}
	//
	
	 //private AgencyEntity getLastAgency(){
	//	 agencies = agencyService.findAll();
	//	 return agencies.get(agencies.size()-1);		 
	// }
	
}
