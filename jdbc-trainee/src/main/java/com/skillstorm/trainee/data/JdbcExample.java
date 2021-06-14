package com.skillstorm.trainee.data;

// java.sql pacakage
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.skillstorm.trainee.models.Trainee;

public class JdbcExample {
	// url is jdbc:mysql://HOST_NAME:PORT_NUMBER/DB_NAME
	// jdbc:mysql://55.78.99.122:3306/training
	private static final String url = "jdbc:mysql://localhost:3306/training";
	private static final String username = "root";
	private static final String password = "root";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		insert();
	}

	public static void insert() throws SQLException, ClassNotFoundException {
		// 0. Bootstrap the driver class (optional/**recommend**)
		// Class.forName("com.mysql.jdbc.Driver"); // old deprecated driver
		Class.forName("com.mysql.cj.jdbc.Driver"); // forces the class to be loaded by JVM

		// 1. Establish a Connection
		Connection connection = DriverManager.getConnection(url, username, password);
		// com.mysql.cj.jdbc.ConnectionImpl : InterfaceName"Impl" a common naming
		// convention
		System.out.println(connection);

		// 2. Statement (sql compiled by DB) vs PreparedStatement (sql compiled in Java)
		String sql = "insert into trainee(trainee_name, trainee_major) values (?, ?)";
		Trainee obj = new Trainee("a'; drop table trainee --", "Computer Science");
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, obj.getName()); // parameter binding
		statement.setString(2, obj.getMajor());
		statement.executeUpdate(); // compile the SQL, send it the database
		
		// Trainee obj = new Trainee("Dan Pickles", "Computer Science");
		// command/code injection attack (SQL Injection attack)
		/*// don't use Statement object (never)
		 * String sql = "insert into trainee(trainee_name, trainee_major) values ('" +
		 * obj.getName() + "', '" + obj.getMajor() + "')"; statement.executeUpdate(sql);
		 */ // sends the SQL to MySQL to be compiled/run
		System.out.println("Complete");

	}

}
