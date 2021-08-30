package org.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.ResourceDao;




@WebServlet("/ReserveResource")
public class ReserveResource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReserveResource() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String netId = (String) session.getAttribute("netId");
		String firstName = (String) session.getAttribute("firstName");
		String lastName = (String) session.getAttribute("lastName");
		String userName = firstName + " " + lastName ;
		
		try {
			
		String resourceName = request.getParameter("resourceName");
		String reserveDate = request.getParameter("reserveDate");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");               
	    java.util.Date date = null;
	    try
	    {
	        date = dateFormat.parse(reserveDate);

	    } catch (ParseException e)
	   {
	        e.printStackTrace();
	    }
		
	
		
		String timeSlot = request.getParameter("timeSlot");
		
		ResourceDao resource = new ResourceDao();
		resource.reserveResource(netId, userName, resourceName, dateFormat.format(date), timeSlot);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//response.getWriter().append("One resourceis reserved by user named " +userName.toUpperCase() + ".");
		response.sendRedirect("HomePage.jsp");
	}

}
