package org.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.project.dao.DiscussionDao;

/**
 * Servlet implementation class CreateDiscussionTopic
 */
@WebServlet("/CreateDiscussionTopic")
public class CreateDiscussionTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CreateDiscussionTopic() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String topicId = request.getParameter("topicId");
		String topicName = request.getParameter("topicName");
		
		DiscussionDao discussion = new DiscussionDao();
		discussion.createDiscussionTopic(topicId, topicName);
		
		//response.getWriter().println("Your discussion topic has been added to database");
		response.sendRedirect("HomePage.jsp");
	}

}
