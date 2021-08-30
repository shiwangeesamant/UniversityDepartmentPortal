package org.project.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.LogInDAO;
import org.project.dao.ResourceDao;
import org.project.dao.UserDao;


@WebServlet("/StaffServices")
public class StaffServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StaffServices() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String netId = (String) session.getAttribute("netId");
		String passWord = (String) session.getAttribute("passWord");
		
		String resourceName = request.getParameter("resourceName");
		String timeSlot = request.getParameter("timeSlot");
		
		
		ResourceDao resource = new ResourceDao();
		
		
		//user.createResource(resourceName, timeSlot);	
		
		LogInDAO login = new LogInDAO();
		ResultSet userDetails = login.searchUserId(netId, passWord);
		
		
		try {
			if(userDetails.first()) {
				
				request.getSession(true).setAttribute("isUserLoggedIn", "true");
				String roleValue = userDetails.getString("Role");
				
				if(roleValue.equals("Staff")) {
					resource.createResource(resourceName, timeSlot);
				} else {
					System.out.println("Only Staff can add a resource.");
					response.getWriter().print("One Resource got add to the record");
				}
			
					
				
			
			}else {
				
				request.getSession(true).setAttribute("isUserLoggedIn", "false");
				//out.println("Invalid User Id OR Password \n");
				System.out.println("Invalid User Id OR Password \n");
				
		}
//					
			
		} catch (SQLException e) {
			 e.printStackTrace();
		} 
		//response.getWriter().println("One Resource got add to the database");
		response.sendRedirect("HomePage.jsp");
}
	}
