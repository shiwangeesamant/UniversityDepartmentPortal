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

import org.project.dao.JobDao;

/**
 * Servlet implementation class ViewAppliedJob
 */
@WebServlet("/ViewAppliedJob")
public class ViewAppliedJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAppliedJob() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JobDao job = new JobDao();
		HttpSession session = request.getSession();
		String netId =(String) session.getAttribute("netId");
		ResultSet result = job.viewAppliedJob(netId);
		
		request.setAttribute("jobResult", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewAppliedJob.jsp");
		dispatcher.forward(request, response);
	}

}
