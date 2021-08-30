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
 * Servlet implementation class ViewPhDStudentDetails
 */
@WebServlet("/ViewPhDStudents")
public class ViewPhDStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewPhDStudents() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao user = new UserDao();
		ResultSet studentDetails = user.ViewPhDStudentDetails();
		
		HttpSession session = request.getSession(true);
		
	/*	String selectedNetId = (String) session.getAttribute("NetId");
		ResultSet studentDetailsByNetId = user.PhDStudentDetailsByNetId(selectedNetId); */
		
/*		try{
			if(studentDetails.next()) {
				
				String netId = studentDetails.getString("netId");
				String firstName = studentDetails.getString("firstName");
				String lastName = studentDetails.getString("lastName");
				String yearOfJoining = studentDetails.getString("yearOfJoining");
				//String numberOfSemester = studentDetails.getString("noOfSemester");
				String major = studentDetails.getString("Major");
				String grade = studentDetails.getString("grade");
			System.out.println(netId + " FirstName :"  + firstName);	
				request.setAttribute("studentDetails", studentDetails);
				
				RequestDispatcher view = request.getRequestDispatcher("ViewPhdStudents.jsp");
		          view.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}  */
		
		request.setAttribute("studentDetails", studentDetails);
		
		RequestDispatcher view = request.getRequestDispatcher("ViewPhdStudents.jsp");
          view.forward(request, response);
	}

}
