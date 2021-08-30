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

import org.project.dao.ResourceDao;

/**
 * Servlet implementation class ViewResources
 */
@WebServlet("/ViewResources")
public class ViewResources extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewResources() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ResourceDao resource = new ResourceDao();
		ResultSet resourceResult = resource.viewResources();
		
		try {
			while(resourceResult.next()) {
				
				request.setAttribute("resources", resourceResult) ;
				RequestDispatcher dispatcher = request.getRequestDispatcher("ViewResources.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
