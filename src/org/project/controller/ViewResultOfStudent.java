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
import javax.servlet.http.HttpSession;

import org.project.dao.ExamDao;

/**
 * Servlet implementation class ViewResultOfStudent
 */
@WebServlet("/ViewResultOfStudent")
public class ViewResultOfStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewResultOfStudent() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ExamDao examDetails = new ExamDao();
		HttpSession session = request.getSession();
		
		String netId = (String) session.getAttribute("netId");
		ResultSet examResult = examDetails.searchResultyByStudent(netId);
		
		
				
				request.setAttribute("results", examResult);
				RequestDispatcher dispatcher = request.getRequestDispatcher("ViewResultOfStudent.jsp");
				dispatcher.forward(request, response);
			
		
		
	}

}
