package org.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutUser
 */
@WebServlet("/LogOutUser")
public class LogOutUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogOutUser() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String message= "You are successfully logged out!";
        request.setAttribute("LogOutMessage", message);
          
        request.getRequestDispatcher("RegistrationForm.jsp").forward(request, response);  
          
        HttpSession session=request.getSession();  
        session.invalidate();  
         
        
       // out.print("You are successfully logged out!");  
          
        out.close(); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
