package org.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.UserDao;

/**
 * Servlet implementation class SubmitPhDStudentDetails
 */
@WebServlet("/SubmitPhDStudentDetails")
public class SubmitPhDStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SubmitPhDStudentDetails() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String netId = (String) session.getAttribute("netId");
		String noOfSemester = request.getParameter("noOfSemester");
		String major = request.getParameter("major");
		String studentStatus = request.getParameter("studentStatus");
		
		UserDao user = new UserDao();
		user.updatePhDStudentData(netId, noOfSemester, major, studentStatus);
		response.sendRedirect("HomePage.jsp");
	}

}
