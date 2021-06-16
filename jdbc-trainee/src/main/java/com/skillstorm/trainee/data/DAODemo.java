package com.skillstorm.trainee.data;

import com.skillstorm.trainee.models.Trainee;

public class DAODemo {

	public static void main(String[] args) {
		Trainee record = new Trainee("Randolph Scott", "Business");
		TraineeDAO dao = new TraineeDAOImpl();
		dao.save(record);
		System.out.println("Complete");
	}
	
}
