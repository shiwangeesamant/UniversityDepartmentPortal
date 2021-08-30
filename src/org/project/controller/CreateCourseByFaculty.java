package org.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.FacultyDao;
@WebServlet("/CreateCourseByFaculty")
public class CreateCourseByFaculty extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String netId = (String) session.getAttribute("netId");
		String firstName = (String) session.getAttribute("firstName");
		String lastName = (String) session.getAttribute("lastName");
		
		try {
			FacultyDao faculty = new FacultyDao();
						
			int courseNumber = Integer.parseInt(request.getParameter("courseNumber"));
			String courseName = request.getParameter("courseName");		
			
			//session1.setAttribute("courseName", courseName);
			
			faculty.createCourse(netId,courseNumber, courseName, firstName, lastName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		//response.getWriter().append(("One Course is added by Faculty named " +firstName.toUpperCase()+" "+lastName.toUpperCase()));
		response.sendRedirect("HomePage.jsp");
	}

}
