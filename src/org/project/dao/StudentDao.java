package org.project.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import org.dabase.connection.DatabaseConnection;

public class StudentDao {
	
	static Connection dbConnection = DatabaseConnection.getConnection();
	
	public void createStudentDetails( int year, String program) {
		
		try {
			String query = "insert into userDetails (year, program) values (?,?)";
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setInt(1, year);
			pstmt.setString(2, program);
			
			
			pstmt.executeUpdate();
			
			pstmt.close();

			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	

}
