package org.project.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.AnnouncementDao;

/**
 * Servlet implementation class ViewAnnouncements
 */
@WebServlet("/ViewAnnouncements")
public class ViewAnnouncements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewAnnouncements() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AnnouncementDao announce = new AnnouncementDao();
		ResultSet announceDetails = announce.selectAnnouncements();
		
		try {
			while(announceDetails.next()) {
				request.setAttribute("announceDetails", announceDetails) ;
				RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAnnouncements.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
