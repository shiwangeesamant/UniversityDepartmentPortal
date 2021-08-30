package org.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.ResourceDao;

/**
 * Servlet implementation class CancelResource
 */
@WebServlet("/CancelResource")
public class CancelResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CancelResource() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String netId = (String) session.getAttribute("netId");
		String firstName = (String) session.getAttribute("firstName");
		String lastName = (String) session.getAttribute("lastName");
		String userName = firstName + " " + lastName;
		
		String resourceName = request.getParameter("resourceName");
		
		ResourceDao resource = new ResourceDao();
		resource.deleteResource(netId, resourceName);
		
		//response.getWriter().println("Your reservation has been canceled");
		response.sendRedirect("HomePage.jsp");
	}

}
