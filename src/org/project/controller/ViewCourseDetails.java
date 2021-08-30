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

import org.project.dao.FacultyDao;

/**
 * Servlet implementation class ViewCourseDetails
 */
@WebServlet("/ViewCourseDetails")
public class ViewCourseDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FacultyDao faculty = new FacultyDao();
		ResultSet result = faculty.viewCourse();
		
		try {
			while(result.next()) {
				
				request.setAttribute("courseDetails", result);
				
				RequestDispatcher view = request.getRequestDispatcher("ViewCourseDetails.jsp");
		          view.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
