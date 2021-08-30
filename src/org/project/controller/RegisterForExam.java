package org.project.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.ExamDao;

/**
 * Servlet implementation class RegisterForExam
 */
@WebServlet("/RegisterForExam")
public class RegisterForExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterForExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String netId = (String) session.getAttribute("netId");
		String firstName = (String) session.getAttribute("firstName");
		String lastName = (String) session.getAttribute("lastName");
		
		String examName= request.getParameter("examName");
		String studentId= request.getParameter("studentId");
		
		ExamDao exam= new ExamDao();
		String strUserMsg = null;
		
		exam.registerExam(netId, firstName, lastName, studentId,examName);
	/*	try{
		ResultSet result = exam.StudentDetailsBySemester(netId, studentId, examName);
		if(result.first()) {
			strUserMsg = request.getParameter("examName")+" exam already exists. Please register for another exam.";
			request.setAttribute("ErrorMsg", strUserMsg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewExamDetails.jsp");
			dispatcher.forward(request, response);
		} else {
		exam.registerExam(netId, firstName, lastName, studentId,examName);
		} 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	} */
	}
}
