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
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
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
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(FIND_ALL);
			while (resultSet.next()) {
				Trainee object = new Trainee(resultSet.getInt("id"), resultSet.getString("trainee_name"),
						resultSet.getString("trainee_major"));
				trainees.add(object);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainees;
	}

	public Trainee findById(int id) {
		final String FIND_BY_ID = "select id, trainee_name, trainee_major from trainee where id = ?";
		Trainee trainee = null;
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			PreparedStatement stmt = connection.prepareStatement(FIND_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next(); // one result
			int result_id = rs.getInt("id");
			String result_name = rs.getString("trainee_name");
			String result_major = rs.getString("trainee_major");
			trainee = new Trainee(result_id, result_name, result_major);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainee;
	}

	// assume their ID is already populated in trainee object
	@Override
	public void update(Trainee trainee) {
		String sql = "update trainee set trainee_name = ?, trainee_major = ? where id = ?";
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			PreparedStatement stmt = connection.prepareStatement(sql);
			// parameter binding
			stmt.setString(1, trainee.getName());
			stmt.setString(2, trainee.getMajor());
			stmt.setInt(3, trainee.getId());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		throw new UnsupportedOperationException("Still working on it");
	}

	public List<Trainee> findByMajor(String major) {
		throw new UnsupportedOperationException("Still working on it");
	}

}
