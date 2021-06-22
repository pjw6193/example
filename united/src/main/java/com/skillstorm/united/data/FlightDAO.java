package com.skillstorm.united.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class FlightDAO {
	
	public void hello() {
		try(Connection conn = DriverManager.getConnection(null, null, null);){
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
