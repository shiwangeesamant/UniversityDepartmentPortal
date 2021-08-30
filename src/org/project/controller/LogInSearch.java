package org.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.LogInDAO;
import org.project.dao.UserDao;


//@WebServlet("/LogInSearch")
public class LogInSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogInSearch() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		LogInDAO login = new LogInDAO();
		UserDao user = new UserDao();
		
		
		HttpSession session = request.getSession(true);
		
		String id = request.getParameter("netId");
		String word = request.getParameter("passWord");
		
		session.setAttribute("netId", id);
		session.setAttribute("passWord", word);
		
		ResultSet userDetails = login.searchUserId(id, word);
		
			try {
			if(userDetails.first()) {
				
				String roleValue = userDetails.getString("Role");
				session.setAttribute("roleValue", roleValue);
				
				String firstName = userDetails.getString("firstName");
				String lastName = userDetails.getString("lastName");
				session.setAttribute("firstName", firstName);
				session.setAttribute("lastName", lastName);
				
				request.getSession(true).setAttribute("isUserLoggedIn", "true");
				
			response.sendRedirect("HomePage.jsp");
				
	/*			if(roleValue.equals("Student")) {
					
					ResultSet loggedStudent = user.searchLoggedInStudent(id, word);
					if(loggedStudent.first()) {
						String programOfStudent = loggedStudent.getString("programTaken");
						session.setAttribute("programOfStudent", programOfStudent);
						System.out.println(programOfStudent);
					}  */
					
				
				
				
			} else {
				
					request.getSession(true).setAttribute("isUserLoggedIn", "false");
					out.println("Invalid User Id OR Password \n");
					
				}
				
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		/*
			System.out.println("Before Login IF");
			if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
				System.out.println("LOGGED IN SUCCESSFULLY");
			}
			System.out.println("After Login IF");     */
	}

}
