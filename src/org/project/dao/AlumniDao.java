package org.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import org.dabase.connection.DatabaseConnection;

public class AlumniDao {
	
	static Connection dbConnection = DatabaseConnection.getConnection();
	
	public  void createAlumniInfo(String alumniName, String programTaken, String major, int passedOutYear) {
		
		try {
		String query = "insert into AlumniInfo(alumniName, programTaken, major, passedOutYear) values(?,?,?,?)";
			
		
			PreparedStatement pstmt= dbConnection.prepareStatement(query);
			
				
				pstmt.setString(1, alumniName);
				pstmt.setString(2, programTaken);
				pstmt.setString(3, major);
				pstmt.setInt(4, passedOutYear);
				
				pstmt.executeUpdate();
				pstmt.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}		
	}
	
	public static ResultSet selectAlumniInfo() {
		ResultSet result = null;
		try{
			
		Statement stmt = dbConnection.createStatement();
		String query = "select * from AlumniInfo";
	    result = stmt.executeQuery(query);
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public void editAlumniInfo(String alumniName, String programTaken, String major, int passedOutYear) {
		
		String query = "UPDATE AlumniInfo SET programTaken=?, major=?, passedOutYear=? WHERE alumniName=?";
		try {
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setString(1, programTaken);
			pstmt.setString(2, major);
			pstmt.setInt(3, passedOutYear);
			pstmt.setString(4, alumniName);
			
			pstmt.executeUpdate();  
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
