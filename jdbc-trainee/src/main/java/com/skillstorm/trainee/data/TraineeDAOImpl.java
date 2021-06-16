package com.skillstorm.trainee.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.trainee.models.Trainee;

// pronounciation "DOW" D-A-O. 
public class TraineeDAOImpl implements TraineeDAO {

	private static final String INSERT = "insert into trainee(trainee_name, trainee_major) values (?,?)";
	private static final String FIND_ALL = "select id, trainee_name, trainee_major from trainee";
	
	// force the driver class into JVM, do that once
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void save(Trainee trainee) {
		// Connection pool (managed by your server)
		// grab a connection from the pool. close it when you're done
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			PreparedStatement stmt = connection.prepareStatement(INSERT);
			stmt.setString(1, trainee.getName());
			stmt.setString(2, trainee.getMajor());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Trainee> findAll() {
		List<Trainee> trainees = new LinkedList<>(); 
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			// load the rows into the list
			Statement stmt = connection.createStatement(); // no parameter in SQL
			// returns ResultSet - represents the rows from the database
			ResultSet resultSet = stmt.executeQuery(FIND_ALL);
			// results in SQL point to an empty row (row 0) - loop thru the results
			while(resultSet.next()) { // 1st time called will move to row 1
				// start processing each row
				// convert the data into Trainee objects (object-relational mapping - Hibernate/JPA)
				// id, name, major
				Trainee object = new Trainee(resultSet.getInt("id"), 
									resultSet.getString("trainee_name"), 
									resultSet.getString("trainee_major"));
				trainees.add(object);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return trainees;
	}

	public Trainee findById(int id) {
		throw new UnsupportedOperationException("Still working on it");
	}

	public void update(Trainee trainee) {
		throw new UnsupportedOperationException("Still working on it");
	}

	public void delete(int id) {
		throw new UnsupportedOperationException("Still working on it");
	}

}
