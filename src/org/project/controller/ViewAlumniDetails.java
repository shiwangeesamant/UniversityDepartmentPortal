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

import org.project.dao.AlumniDao;

/**
 * Servlet implementation class ViewAlumniDetails
 */
@WebServlet("/ViewAlumniDetails")
public class ViewAlumniDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewAlumniDetails() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AlumniDao alumni = new AlumniDao();
		ResultSet alumniInfo = alumni.selectAlumniInfo();
		
		try {
			if(alumniInfo.first()) {
				request.setAttribute("alumniInfo", alumniInfo) ;
				RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAlumniInfo.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
