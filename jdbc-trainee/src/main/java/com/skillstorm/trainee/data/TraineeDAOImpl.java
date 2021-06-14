package com.skillstorm.trainee.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.skillstorm.trainee.models.Trainee;

// pronounciation "DOW" D-A-O. 
public class TraineeDAOImpl implements TraineeDAO {

	private static final String INSERT = "insert into trainee(trainee_name, trainee_major) values (?,?)";
	
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
		throw new UnsupportedOperationException("Still working on it");
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
