package org.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.ExamDao;



@WebServlet("/PostResultOfStudent")
public class PostResultOfStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PostResultOfStudent() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String examName = request.getParameter("examName");
		String stuExamId = request.getParameter("stuId");
		String studentResult = request.getParameter("examresult");
		
		
		System.out.println(examName +" " +stuExamId );
		ExamDao exam = new ExamDao();
		exam.postResult(examName, stuExamId, studentResult);
		response.sendRedirect("HomePage.jsp");
		
		
		
	}

}
