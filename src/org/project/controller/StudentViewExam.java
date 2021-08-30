package org.project.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.ExamDao;

/**
 * Servlet implementation class StudentRegisterExam
 */
@WebServlet("/StudentViewExam")
public class StudentViewExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ExamDao exam = new ExamDao();
		ResultSet examDetails = exam.selectExam();
		
		request.setAttribute("examDetails", examDetails);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("RegisteExam.jsp");
	    dispatcher.forward(request, response);
	}

}
