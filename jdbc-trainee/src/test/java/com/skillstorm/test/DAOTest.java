package com.skillstorm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.skillstorm.trainee.data.TraineeDAO;
import com.skillstorm.trainee.data.TraineeDAOImpl;
import com.skillstorm.trainee.models.Trainee;

public class DAOTest {

	@Test
	public void testFindAll() {
		TraineeDAO dao = new TraineeDAOImpl();
		List<Trainee> results = dao.findAll();
		System.out.println(results);
		assertTrue(results.size() > 0);
	}
	
}
