package org.project.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.FacultyDao;

/**
 * Servlet implementation class ViewProfessorOfficeHr
 */
@WebServlet("/ViewProfessorOfficeHr")
public class ViewProfessorOfficeHr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewProfessorOfficeHr() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FacultyDao data = new FacultyDao();
		
		ResultSet courseData = data.viewCourse();
		
		request.setAttribute("officeHr", courseData) ;
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewProfessorOfficeHr.jsp");
		dispatcher.forward(request, response);
		
	}

}
