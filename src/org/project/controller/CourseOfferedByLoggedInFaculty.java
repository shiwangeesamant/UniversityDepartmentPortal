package org.project.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.FacultyDao;

/**
 * Servlet implementation class CourseOfferedByLoggedInFaculty
 */
@WebServlet("/CourseOfferedByLoggedInFaculty")
public class CourseOfferedByLoggedInFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CourseOfferedByLoggedInFaculty() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String netId = (String) session.getAttribute("netId");
		
		FacultyDao faculty = new FacultyDao();
		ResultSet courseByFaculty= faculty.searchCourseBynetId(netId);
		
		
		try {
			while(courseByFaculty.next()) {
				
				String courseName = courseByFaculty.getString("courseName");
				
				
				request.setAttribute("course", courseByFaculty);
				RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCourseByLoggedInId.jsp");
				dispatcher.forward(request, response);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
