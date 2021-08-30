package org.project.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.ExamDao;


@WebServlet("/CreateExam")
public class CreateExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateExam() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String examName= request.getParameter("examName");
		String examDate = request.getParameter("examDate");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");               
	    java.util.Date date = null;
	    try
	    {
	        date = dateFormat.parse(examDate);

	    } catch (ParseException e)
	   {
	        e.printStackTrace();
	    }
	    
	    ExamDao exam = new ExamDao();
	    exam.createExam(examName, dateFormat.format(date));
	    response.sendRedirect("HomePage.jsp");
	}

}
