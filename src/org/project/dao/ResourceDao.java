package org.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import org.dabase.connection.DatabaseConnection;

public class ResourceDao {
	
	static Connection dbConnection = DatabaseConnection.getConnection();
	
	public void createResource( String resourceName, String timeSlot) {
		try {
			String query = "insert into resource (resourceName, timeSlot) values (?,?)";
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setString(1, resourceName);
			pstmt.setString(2, timeSlot);
			pstmt.executeUpdate();
			
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void reserveResource (String netId, String userName, String resourceName, String date, String timeSlot) { 
		
		try {
		String query = "insert into reserveResource(netId,userName, resourceName, reserveDate, timeSlot) values (?,?,?,?,?)";
		PreparedStatement pstmt = dbConnection.prepareStatement(query);
		pstmt.setString(1, netId);
		pstmt.setString(2, userName);
		pstmt.setString(3, resourceName);
		pstmt.setString(4, date);
		pstmt.setString(5, timeSlot);
		
		pstmt.executeUpdate();
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static ResultSet viewResources() {
		ResultSet result = null;
		try{
			
		Statement stmt = dbConnection.createStatement();
		String query = "select * from reserveResource";
	    result = stmt.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public static ResultSet searchResourceBynetId( String netId) {
		ResultSet result = null;
		try {
			Statement stmt = dbConnection.createStatement();
			String query = "select * from reserveResource where netId='"+netId+"'";
			result = stmt.executeQuery(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
		
	}
	
	public void deleteResource( String netId, String resourceName) {
		
		
		
		try {
			String query = "DELETE from reserveResource where netId=? AND resourceName=?";
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setString(1, netId);
			pstmt.setString(2, resourceName);
			
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*	try {
		Statement stmt = dbConnection.createStatement();
		
		int result = stmt.executeUpdate(query);
		System.out.println("One row is deleted");
        stmt.close();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}*/
	}

}
