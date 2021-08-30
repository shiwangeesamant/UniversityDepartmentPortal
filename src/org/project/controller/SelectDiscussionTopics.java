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

import org.project.dao.DiscussionDao;

/**
 * Servlet implementation class SelectDiscussionTopics
 */
@WebServlet("/SelectDiscussionTopics")
public class SelectDiscussionTopics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectDiscussionTopics() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DiscussionDao discussion = new DiscussionDao();
		ResultSet discussionTopics = discussion.selectTopic();
		
		try {
		while(discussionTopics.next()) {
			
				//String topicName = topics.getString("topicName");
				
				request.setAttribute("topics", discussionTopics);
				RequestDispatcher view = request.getRequestDispatcher("ParticipateInDiscussion.jsp");
		          view.forward(request, response);
			} 
		}catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}


