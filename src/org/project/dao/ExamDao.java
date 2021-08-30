package org.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mysql.jdbc.Connection;

import org.dabase.connection.DatabaseConnection;

public class ExamDao {
	
	static Connection dbConnection = DatabaseConnection.getConnection();
	
	public void createExam(String examName, String examDate) {
		
		try {
			String query = "insert into examDetails(examName, examDate) values(?,?)";
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setString(1, examName);
			pstmt.setString(2, examDate);
			
			
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static ResultSet selectExam() {
		ResultSet result = null;
		try{
			
		Statement stmt = dbConnection.createStatement();
		String query = "select * from examDetails";
	    result = stmt.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	


public static ResultSet selectExamResult() {
	ResultSet result = null;
	try{
		
	Statement stmt = dbConnection.createStatement();
	String query = "select * from ExamResult";
    result = stmt.executeQuery(query);
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return result;
	
}

public void registerExam(String netId,String firstName, String lastName ,String stuExamId, String examName) {
	
	try {
		String query = "insert into studentRegisterExam(netId,firstName,lastName, stuExamId, examName) values(?,?,?,?,?)";
		PreparedStatement pstmt = dbConnection.prepareStatement(query);
		pstmt.setString(1, netId);
		pstmt.setString(2, firstName);
		pstmt.setString(3, lastName);
		pstmt.setString(4, stuExamId);
		pstmt.setString(5, examName);
		
		
		pstmt.executeUpdate();
		pstmt.close();
		
	} catch(SQLException ex) {
		ex.printStackTrace();
	}
}
public void postResult(String examName, String stuExamId, String studentResult) {
	
	try {
		String query = "update studentRegisterExam set studentResult=? where stuExamId=? and examName=?";
		PreparedStatement pstmt = dbConnection.prepareStatement(query);
		pstmt.setString(1, studentResult);
		pstmt.setString(2, stuExamId);		
		pstmt.setString(3, examName);           /* examName=? and*/
		
		pstmt.executeUpdate();
		pstmt.close();
		
	} catch(SQLException ex) {
		ex.printStackTrace();
	}
}

public static ResultSet studentRegistered() {
	ResultSet result = null;
	try{
		
	Statement stmt = dbConnection.createStatement();
	String query = "select * from studentRegisterExam";
    result = stmt.executeQuery(query);
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return result;
	
}

public ResultSet StudentDetailsBySemester(String netId, String stuExamId, String examName) {
	
	ResultSet result = null;
	try {
		String query = "Select * from studentRegisterExam WHERE netId=? and stuExamId=? and examName=?";
		PreparedStatement pstmt = dbConnection.prepareStatement(query);
		pstmt.setString(1, netId);
		pstmt.setString(2, stuExamId);
		pstmt.setString(3, examName);
		
		pstmt.executeQuery();
		pstmt.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return result;
}

public static ResultSet searchResultyByStudent(String netId) {
	
	ResultSet result = null;
	try {
	
	String query = "select * from studentRegisterExam where netId=?";
	PreparedStatement pstmt = dbConnection.prepareStatement(query);
	pstmt.setString(1, netId);
	pstmt.executeUpdate();
	pstmt.close();
	}
	catch(SQLException ex) {
		ex.printStackTrace();
	}
	return result;

} 

}
