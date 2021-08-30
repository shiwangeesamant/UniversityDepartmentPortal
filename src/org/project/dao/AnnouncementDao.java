package org.project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import org.dabase.connection.DatabaseConnection;


public class AnnouncementDao {
	
	static Connection dbConnection = DatabaseConnection.getConnection();
	
	public void createAnnouncement(String netId, String firstName, String lastName, int announcementId, String announceText) {
		try {
		String query = "insert into postAnnouncements(netId,firstName,lastName,announcementId,announceText) values(?,?,?,?,?)";
		
			PreparedStatement pstmt = dbConnection.prepareStatement(query);
			pstmt.setString(1, netId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setInt(4, announcementId);
			pstmt.setString(5, announceText);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static ResultSet selectAnnouncements() {
		
		ResultSet result = null;
		try{
			
		Statement stmt = dbConnection.createStatement();
		String query = "select * from postAnnouncements";
	    result = stmt.executeQuery(query);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
