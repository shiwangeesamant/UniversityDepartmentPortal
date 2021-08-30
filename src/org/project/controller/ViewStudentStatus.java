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


@WebServlet("/ViewStudentStatus")
public class ViewStudentStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewStudentStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String NetId = (String) session.getAttribute("netId");
		
		UserDao user = new UserDao();
		ResultSet userdetails = user.selectStudentData(NetId);				
						request.setAttribute("loggedInStudent", userdetails);
						RequestDispatcher dispatcher = request.getRequestDispatcher("ViewStudentStatus.jsp");
						dispatcher.forward(request, response);

		
	}

}
