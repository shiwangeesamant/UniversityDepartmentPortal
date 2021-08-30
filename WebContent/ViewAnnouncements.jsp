<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.sql.*" %>

<head>
<%@ include file="Menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Announcements Here</title>
</head>
<body>
<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
%>
<table cellspacing="15">
	<tr>
		<th>Announcement Id</th>
		<th>Announcement Content</th>
	</tr>
	
	<% 
		ResultSet announceDetails = (ResultSet) request.getAttribute("announceDetails");
		while(announceDetails.next()) {
	%>	
	
	<tr>
		<td><%= announceDetails.getInt("announcementId") %></td>
		<td><textarea rows="10" cols="10" ><%= announceDetails.getString("announceText") %></textarea></td>
	</tr>
	<% } %>
</table>

<% } else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>