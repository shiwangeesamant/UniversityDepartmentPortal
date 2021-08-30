package org.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import org.dabase.connection.DatabaseConnection;

public class JobDao {

	static Connection dbConnection = DatabaseConnection.getConnection();
	
	public void createJob(String netId, String firstName, String lastName, String jobId, String jobRole, String jobContent) {
		
		try {
			String query = "insert into JobDetails(netId, firstName, lastName, jobId, jobRole, jobContent) values(?,?,?,?,?,?)";
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setString(1, netId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, jobId);
			pstmt.setString(5, jobRole);
			pstmt.setString(6, jobContent);
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static ResultSet viewJobDetails() {
		ResultSet result = null;
		try {
			Statement stmt = dbConnection.createStatement();
			String query = "select * from JobDetails";
			result = stmt.executeQuery(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	
	
public void studentAppliedJob(String netId, String firstName, String lastName,String jobId , String jobRole,String jobstatus) {
	
		try {
			String query = "insert into studentJob(netId, firstName, lastName, jobId, jobRole, jobstatus) values(?,?,?,?,?,?)";
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setString(1, netId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, jobId);
			pstmt.setString(5, jobRole);
			pstmt.setString(6, jobstatus);
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public static ResultSet viewAppliedJob(String netId) {
	ResultSet result = null;
	try {
		
		String query = "select * from studentJob where netId=?";
		PreparedStatement pstmt = dbConnection.prepareStatement(query);
		pstmt.setString(1, netId);
		
		pstmt.executeQuery();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	
	return result;
	
}
}
