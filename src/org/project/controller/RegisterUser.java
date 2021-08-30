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

import org.project.dao.UserDao;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		HttpSession session = request.getSession();
		UserDao user = new UserDao();
		String strUserMsg = null;
		
		String netId = request.getParameter("netId");
		String passWord = request.getParameter("passWord");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailId =request.getParameter("emailId");
		String Role = request.getParameter("Role");
		
		try {
			
			//if(!netId.isEmpty() && !passWord.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() ) {
				
				ResultSet result = user.searchUserId(netId);
				if(result.next()) {
					strUserMsg = "Net Id "+request.getParameter("netId")+" already exists. Please try with another NetId.";
					request.setAttribute("ErrorMsg", strUserMsg);
					RequestDispatcher dispatcher = request.getRequestDispatcher("RegistrationForm.jsp");
					dispatcher.forward(request, response);
				} else {
					user.createUser(netId, passWord, firstName, lastName, Role, emailId);
					if(Role.equals("Student") ){
									
						int year = Integer.parseInt(request.getParameter("yearOfJoining"));
					
						String program = request.getParameter("programTaken");
						user.updateStudentData(netId, firstName, lastName, year, program, emailId);
						} 
				RequestDispatcher view = request.getRequestDispatcher("LoginPage.jsp");
		        view.forward(request, response);
				}
		
		} catch(Exception ex) {
			ex.printStackTrace();
	
      } 
  
	}
	
	

}
