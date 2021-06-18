package com.skillstorm.services;

import java.util.List;

import com.skillstorm.trainee.data.TraineeDAO;
import com.skillstorm.trainee.data.TraineeDAOImpl;
import com.skillstorm.trainee.models.Trainee;

/**
 * Service class is the brains
 */
public class TraineeService {

	private TraineeDAO dao = new TraineeDAOImpl();
	
	public List<Trainee> findAll(){
		List<Trainee> trainees = dao.findAll();
		// business logic / application logic
		return trainees;
	}
	
	public Trainee save(Trainee trainee) {
		return dao.save(trainee);
	}
	
}
