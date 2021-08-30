package org.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.AlumniDao;

/**
 * Servlet implementation class PostAlumniInfo
 */
@WebServlet("/PostAlumniInfo")
public class PostAlumniInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PostAlumniInfo() {
        super();
        
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String alumniName = request.getParameter("alumniName");
		String programTaken = request.getParameter("programTaken");
		String major = request.getParameter("major");
		int passedOutYear = Integer.parseInt(request.getParameter("passedOutYear"));
		
		AlumniDao alumni = new AlumniDao();
		alumni.createAlumniInfo(alumniName, programTaken, major, passedOutYear);
		
		//response.getWriter().println("You have post the alumni info successfully");
		response.sendRedirect("HomePage.jsp");
		
	}

}
