package org.project.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;

import org.project.dao.FacultyDao;

@WebServlet("/FacultyCourseDetails")
@MultipartConfig
public class FacultyCourseDetails extends HttpServlet{
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		FacultyDao faculty = new FacultyDao();
		
		HttpSession session = request.getSession();
		InputStream inputstream = null;
		
		String netId = (String) session.getAttribute("netId");
		
				
		String courseName = request.getParameter("courseName");
		String officeHr = request.getParameter("officeHr");
		String TAs = request.getParameter("TAs");
		
		
		//System.out.println(netId +" " + courseName + " " +  officeHr);
		
		Part filepart =  request.getPart("courseSyllabus");
		String syllabus = filepart.getSubmittedFileName();
		
		
		if(filepart != null ) {
			System.out.println(filepart.getName());
			System.out.println(filepart.getSize());
			System.out.println(filepart.getContentType());
			
			inputstream = filepart.getInputStream();
		} 
		
		try {
			faculty.postCourseDetails(netId, courseName, officeHr, TAs, inputstream);
			
		} catch (SerialException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		response.sendRedirect("HomePage.jsp");
		//response.getWriter().print("your course details has been added to database " + netId +" " + courseName + " " +  officeHr);
	}

}
