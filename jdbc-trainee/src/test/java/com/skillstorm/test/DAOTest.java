package com.skillstorm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.skillstorm.trainee.data.TraineeDAO;
import com.skillstorm.trainee.data.TraineeDAOImpl;
import com.skillstorm.trainee.models.Trainee;

public class DAOTest {
	
	@Before
	public void setUp() {
		// run a SQL script to reset the data
	}

	@Test // normally we break this into 2 methods. more likely to re-initialize the entire database for each test.
	public void testInsertAndDelete() {
		TraineeDAO dao = new TraineeDAOImpl();
		Trainee trainee = new Trainee(0, "Test Test", "Testing");
		Trainee updated = dao.save(trainee);
		assertNotEquals(0, updated.getId());
		System.out.println(updated);
		
		// delete
		dao.delete(updated.getId());
		// should not exist in database
		assertNull(dao.findById(updated.getId()));
		
	}
	
	@Test
	public void testUpdate() {
		// when testing, you know your data set very well
		TraineeDAO dao = new TraineeDAOImpl();
		Trainee trainee = new Trainee(2, "Howard Johnson", "Information Technology");
		dao.update(trainee);
		assertEquals(trainee, dao.findById(2));
	}
	
	@Ignore
	@Test
	public void testFindById() {
		TraineeDAO dao = new TraineeDAOImpl();
		Trainee result = dao.findById(1);
		System.out.println(result);
		assertNotNull(result);
	}
	
	@Ignore 
	@Test
	public void testFindAll() {
		TraineeDAO dao = new TraineeDAOImpl();
		List<Trainee> results = dao.findAll();
		System.out.println(results);
		assertTrue(results.size() > 0);
	}
	
}
