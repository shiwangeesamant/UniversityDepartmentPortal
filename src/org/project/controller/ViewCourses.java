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
 * Servlet implementation class ViewCourses
 */
@WebServlet("/ViewCourses")
public class ViewCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewCourses() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	doPost(request, response);
    	
    	
    	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FacultyDao faculty = new FacultyDao();
		ResultSet view = faculty.viewCourse();
		
		try {
			while(view.next()) {
				//int courseNumber = view.getInt("courseNumber");
				//String courseName = view.getString("courseName");
				
				//System.out.println("From servlet " + courseNumber + "  " + courseName);
				request.setAttribute("viewCourses", view) ;
				RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCourses.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
