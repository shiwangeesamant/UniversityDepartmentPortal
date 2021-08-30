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

import org.project.dao.ResourceDao;


@WebServlet("/ReservedResourceByUser")
public class ReservedResourceByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReservedResourceByUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession session = request.getSession();
		
		String netId = (String) session.getAttribute("netId");
//		String firstName = (String) session.getAttribute("firstName");
//		String lastName = (String) session.getAttribute("lastName");
//		String userName = firstName + " " + lastName ;
		
		ResourceDao resource = new ResourceDao();
		 ResultSet reourceDetail = resource.searchResourceBynetId(netId);
		 
		 try {
			while(reourceDetail.next()) {
				 
				 request.setAttribute("reourceDetail", reourceDetail);
					
					RequestDispatcher view = request.getRequestDispatcher("ViewResourceByLoggedInUser.jsp");
			          view.forward(request, response);
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
