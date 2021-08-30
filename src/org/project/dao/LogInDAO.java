package org.project.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import org.dabase.connection.DatabaseConnection;

public class LogInDAO {
	
	static Connection dbConnection = DatabaseConnection.getConnection();
	
	
	
	public static ResultSet searchUserId(String id, String password) {
		ResultSet result = null;
		try {
		Statement stmt = dbConnection.createStatement();
		String query = "select * from userData where netId='"+id + "' and passWord='"+password+"'";
	    result = stmt.executeQuery(query);
		
		
	    while(result.next()) 
	    	result.getString("Role");
	
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return result;

} 
	
	public String getname(String name) {
		return name;
	}

	

	
}
