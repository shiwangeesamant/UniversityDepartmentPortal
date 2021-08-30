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
 * Servlet implementation class CreateJobDetails
 */
@WebServlet("/CreateJobDetails")
public class CreateJobDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateJobDetails() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		HttpSession session = request.getSession();
		String netId = (String) session.getAttribute("netId");
		String firstName = (String) session.getAttribute("firstName");
		String lastName = (String) session.getAttribute("lastName");
		
		String jobId = request.getParameter("jobId");
		String jobRole = request.getParameter("jobRole");
		String jobContent = request.getParameter("jobContent");
		
		JobDao job = new JobDao();
		job.createJob(netId, firstName, lastName, jobId, jobRole, jobContent);
		
		
	} catch(Exception e) {
		e.printStackTrace();
	}
		response.sendRedirect("JobDetail.jsp");

}
}
