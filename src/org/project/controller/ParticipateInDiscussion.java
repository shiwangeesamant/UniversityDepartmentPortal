package org.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.DiscussionDao;


@WebServlet("/ParticipateInDiscussion")
public class ParticipateInDiscussion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ParticipateInDiscussion() {
        super();
        
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String netId = (String) session.getAttribute("netId");
		String firstName = (String) session.getAttribute("firstName");
		String lastName = (String) session.getAttribute("lastName");
		
		String topicId = request.getParameter("topicId");
		String topicContent = request.getParameter("topicContent");
		
		DiscussionDao discuss = new DiscussionDao();
		discuss.participateInDiscussion(topicId, topicContent);
		response.sendRedirect("HomePage.jsp");
		
		
	}

}
