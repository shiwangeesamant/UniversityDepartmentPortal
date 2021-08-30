package org.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mysql.jdbc.Connection;

import org.dabase.connection.DatabaseConnection;


public class UserDao {
	
	static Connection dbConnection = DatabaseConnection.getConnection();
	
	public void createUser(String netId, String passWord,String firstName, String lastName, String Role, String emailId) {
		
		try {
			String query = "insert into userData (netId, passWord,firstName,lastName,Role, emailId) values (?,?,?,?,?,?)";
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setString(1, netId);
			pstmt.setString(2, passWord);
			pstmt.setString(3, firstName);
			pstmt.setString(4, lastName);
			pstmt.setString(5, Role);
			pstmt.setString(6, emailId);
			
			pstmt.executeUpdate();
			
			pstmt.close();

			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static ResultSet searchUserId(String netId) {
		ResultSet result= null;
		try{
			Statement stmt = dbConnection.createStatement();
			String query= "Select * from userData where netId='"+netId+"'";;
			result = stmt.executeQuery(query);
		
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	
	public void updateStudentData(String netId,String firstName, String lastName, int yearOfJoining, String programTaken, String emailId) {
		try {
			String query = "insert into studentData(netId,firstName,lastName, yearOfJoining, programTaken, emailId) values(?,?,?,?,?,?)" ;
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setString(1, netId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setInt(4, yearOfJoining);
			pstmt.setString(5, programTaken);
			pstmt.setString(6, emailId);
			
			pstmt.executeUpdate();
			pstmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
		public static ResultSet searchLoggedInStudent(String id, String password ) {
			
			ResultSet result = null;
			try {
			Statement stmt = dbConnection.createStatement();
			String query = "select * from studentData where netId='"+id + "' and passWord='"+password+"'";
		    result = stmt.executeQuery(query);
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			return result;

	} 
			
			
		
	
	public void updatePhDStudentData(String netId, String noOfSemester,String major, String studentStatus) {
		
		
		
		try {
			String query = "Update studentData SET noOfSemester=?, major=?, studentStatus=? WHERE netId=?";
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			
			pstmt.setString(1, noOfSemester);
			pstmt.setString(2, major);
			pstmt.setString(3, studentStatus);
			pstmt.setString(4, netId);
			
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static ResultSet ViewPhDStudentDetails() {
		ResultSet result = null;
		try{
			String name="Ph.D";
		Statement stmt = dbConnection.createStatement();
		String query = "select * from studentData WHERE programTaken= '" +name+"'";
	    result = stmt.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet StudentDetailsByNetId(String netId) {
		
		ResultSet result = null;
		try {
			String query = "Select * from studentData WHERE netId=?";
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setString(1, netId);
			
			pstmt.executeQuery();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static ResultSet selectStudentData(String netId) {
		ResultSet result= null;
		try{
			Statement stmt = dbConnection.createStatement();
			String query= "Select * from studentData where netId='"+netId+"'";;
			result = stmt.executeQuery(query);
		
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public static ResultSet searchFaculty() {
		ResultSet result = null;
		try{
			String name="Faculty";
		Statement stmt = dbConnection.createStatement();
		String query = "select * from userData WHERE Role= '" +name+"'";
	    result = stmt.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}
