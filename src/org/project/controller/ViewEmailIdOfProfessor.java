package org.project.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.UserDao;

/**
 * Servlet implementation class ViewEmailIdOfProfessor
 */
@WebServlet("/ViewEmailIdOfProfessor")
public class ViewEmailIdOfProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewEmailIdOfProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		String netId = (String) session.getAttribute("netId");
		
		UserDao user = new UserDao();
		
		ResultSet result = user.searchFaculty();
		ResultSet student = user.StudentDetailsByNetId(netId);
		
		request.setAttribute("roleFaculty", result);
		request.setAttribute("studentEmail", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("SendEmailToProfessor.jsp");
		dispatcher.forward(request, response);
	}

}
