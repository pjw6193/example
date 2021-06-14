package com.skillstorm.trainee.data;

import java.util.List;

import com.skillstorm.trainee.models.Trainee;

/**
 * Data Access Object: only job is CRUD operations with a data source
 * Low-level data access. 
 * 
 * Cohesion: a class focuses on one thing.. and it does it well. Small/discrete tasks 
 * (Coupling): connect together (loosely) cohesive classes together
 * 		o --> ! ---> T  ----> car
 * 
 * 	Create 
 * 	Retrieve
 *  Update
 *  Delete
 * 
 */
public interface TraineeDAO {
	// constants are nice inside an interface
	String url = "jdbc:mysql://localhost:3306/training";
	String username = "root";
	String password = "root";

	// decouple from SQL.. whoever calls doesn't use SQL
	// they use model objects
	public void save(Trainee trainee);
	
	public List<Trainee> findAll();
	
	public Trainee findById(int id);
	
	public void update(Trainee trainee);
	
	public void delete(int id);
	
}







