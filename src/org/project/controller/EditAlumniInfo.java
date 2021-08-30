package org.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.AlumniDao;

/**
 * Servlet implementation class EditAluniInfo
 */
@WebServlet("/EditAlumniInfo")
public class EditAlumniInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditAlumniInfo() {
        super();
        
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String alumniName = request.getParameter("alumniName");
		String programTaken = request.getParameter("programTaken");
		String major = request.getParameter("major");
		int passedOutYear = Integer.parseInt(request.getParameter("passedOutYear"));
		
		AlumniDao alumni = new AlumniDao();
		alumni.editAlumniInfo(alumniName, programTaken, major, passedOutYear);
		
		//response.getWriter().println("You have post the alumni info successfully");
	}

}
