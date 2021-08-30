package org.dabase.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DatabaseConnection {
	
private static Connection myconn;
DatabaseConnection dbConnection;

public DatabaseConnection(){
	
}
	public  DatabaseConnection getDatabaseConnection(){
		if(dbConnection!=null){
			return dbConnection;
		} else{
			dbConnection = new DatabaseConnection();
		}
	return	dbConnection;
	}
	
	
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
	
		try {
			if(myconn == null){
				myconn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "shiwangee", "cdoor");
			}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return myconn;
			
		}

	}
		


