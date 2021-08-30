package org.project.dao;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.serial.SerialException;

import com.mysql.jdbc.Connection;

import org.dabase.connection.DatabaseConnection;

public class FacultyDao {
	
	static Connection dbConnection = DatabaseConnection.getConnection();
	
	public static ResultSet searchFaculty(String id, String password) {
		ResultSet result = null;
		try {
		Statement stmt = dbConnection.createStatement();
		String query = "select * from userData where netId='"+id +"'and passWord='"+password+"' ";
	    result = stmt.executeQuery(query);
		
		
	    while(result.next()) 
	    	result.getString("Role");
	
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return result;

} 
	
	public void  createCourse (String netId, int courseNumber, String courseName, String firstName, String lastName) {
		String query = "insert into courseData(netId, courseNumber,courseName, firstName, lastName) values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setString(1, netId);
			pstmt.setInt(2, courseNumber);
			pstmt.setString(3, courseName);
			pstmt.setString(4, firstName);
			pstmt.setString(5, lastName);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static ResultSet viewCourse() {
		ResultSet result = null;
		try {
			Statement stmt = dbConnection.createStatement();
			String query = "select * from courseData";
			result = stmt.executeQuery(query);
			
//			while(result.next()) {
//				System.out.println(result.getInt(1) +"  " + result.getString(2));
//			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	
	public static ResultSet searchCourseBynetId( String netId) {
		ResultSet result = null;
		try {
			Statement stmt = dbConnection.createStatement();
			String query = "select * from courseData where netId='"+netId+"'";
			result = stmt.executeQuery(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	public void postCourseDetails(String netId, String courseName, String officeHr, String TAs, InputStream courseSyllabus) throws SerialException, SQLException {
		
		
		//String query = " insert into courseData values(?,?,?) where (courseNumber="+courseNumber + "And netId="+netId+")";
		//String query = "Update courseData SET officeHr=?, TAs=? , inputStream=? where courseName=?" ;
		try {
			String query = "Update courseData SET officeHr=?, TAs=? , courseSyllabus=? where courseName=? and netId=?" ;
			PreparedStatement pstmt = dbConnection.prepareStatement(query);	
			pstmt.setString(1, officeHr);
			pstmt.setString(2, TAs);
			
			pstmt.setBinaryStream(3, courseSyllabus);
			pstmt.setString(4, courseName);
			pstmt.setString(5, netId);
		
			
			pstmt.executeUpdate();  
			//System.out.println("Record Added");
			pstmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
/*	public static ResultSet viewCourseDetails() {
		ResultSet result = null;
		try {
			Statement stmt = dbConnection.createStatement();
			String query = "select * from courseData";
			result = stmt.executeQuery(query);
			
//			while(result.next()) {
//				System.out.println(result.getInt(1) +"  " + result.getString(2));
//			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
		
	}*/
	

}
