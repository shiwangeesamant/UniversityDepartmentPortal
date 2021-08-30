package org.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.JobDao;

/**
 * Servlet implementation class ApplyForJob
 */
@WebServlet("/ApplyForJob")
public class ApplyForJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ApplyForJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		String netId =(String) session.getAttribute("netId");
		String firstName =(String) session.getAttribute("firstName");
		String lastName =(String) session.getAttribute("lastName");
		
		String jobRole= request.getParameter("jobRole");
		String jobId = request.getParameter("jobId");
		String jobstatus = request.getParameter("job");
		
		JobDao job= new JobDao();
		job.studentAppliedJob(netId, firstName, lastName, jobRole, jobId, jobstatus);
		response.sendRedirect("HomePage.jsp");
	}

}
