package org.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.project.dao.AnnouncementDao;


@WebServlet("/PostAnnouncements")
public class PostAnnouncements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PostAnnouncements() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		HttpSession session = request.getSession();
		
		String netId = (String) session.getAttribute("netId");
		String firstName = (String) session.getAttribute("firstName");
		String lastName = (String) session.getAttribute("lastName");
		
		int announcementId = Integer.parseInt(request.getParameter("announcementId"));
		String announceText = request.getParameter("announceText");
		
		AnnouncementDao announce = new AnnouncementDao();
		announce.createAnnouncement(netId, firstName, lastName, announcementId, announceText);
		
		//String message= "One Announcement has been added to database.";
		//request.setAttribute("postAnnouncement",message );
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("HomePage.jsp");
		
	}

}
