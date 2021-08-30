package org.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import org.dabase.connection.DatabaseConnection;

public class DiscussionDao {
	
	static Connection dbConnection = DatabaseConnection.getConnection();
	
	public void createDiscussionTopic(String topicId, String topicName) {
		try {
			String query = "INSERT into Discussion(topicId, topicName) values(?,?)";
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setString(1, topicId);
			pstmt.setString(2, topicName);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet selectTopic() {
		ResultSet result = null;
		 
		try {
			Statement stmt = dbConnection.createStatement();
			String query = "SELECT * from Discussion";
			result = stmt.executeQuery(query);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		return result;
	}
	
	public void participateInDiscussion(String topicId, String topicContent) {
		try {
			String query = "UPDATE Discussion SET topicContent=? WHERE topicId=?";
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			
			pstmt.setString(1, topicContent);
			pstmt.setString(2, topicId);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
