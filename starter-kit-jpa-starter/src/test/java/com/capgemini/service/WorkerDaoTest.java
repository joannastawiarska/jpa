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

import com.capgemini.domain.AgencyEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.domain.WorkerPositionEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WorkerDaoTest {
	
	@Autowired
	AgencyService agencyService;
	
	@Autowired 
	WorkerService workerService;

	private List<WorkerEntity> workers2 = new ArrayList<WorkerEntity>();
	private WorkerEntity worker3;
	private WorkerEntity worker4;
	private AgencyEntity agencyEntity2;
	
	@Before
	public void setUp(){
		
		worker3 = new WorkerEntity("Mark", "Doe", new WorkerPositionEntity("seller"));
		worker4 = new WorkerEntity("John", "Smith", new WorkerPositionEntity("manager"));

		workerService.save(worker3);
		workerService.save(worker4);
		workers2.add(worker3);
		workers2.add(worker4);

		
		agencyEntity2 = new AgencyEntity("344454", "agency2@xxx.com", workers2);
		agencyService.save(agencyEntity2);
	}
	
	 @After
	 public void tearDown() throws Exception {
		 agencyService.delete(agencyEntity2); 
	}
	 
	 @Test
		public void test() {

			List<WorkerEntity> workersActual = workerService.findWorkersAgency(agencyEntity2);
			
			assertTrue(workersActual.contains(worker3));
			assertTrue(workersActual.contains(worker4));
		}
		
	}
	
	
	 //private AgencyEntity getLastAgency(){
	//	 agencies = agencyService.findAll();
	//	 return agencies.get(agencies.size()-1);		 
	// }
	
