<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Course Details</title>
<%@ include file="Menu.jsp" %>
<%@ page import="java.sql.*" %>
</head>
<body>
<h2>View course details offered by faculty.</h2>
<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){

%>
<table cellspacing="15">
	<tr>
		<th>Course Number</th>
		<th>Course Name</th>
		<th>Office Hour</th>
		<th>TAs</th>
		<th>Course Syllabus</th>
		<th>Professor Name</th>
	</tr>
	<% ResultSet courseDetails = (ResultSet) request.getAttribute ("courseDetails");
		while(courseDetails.next()) {
	%>
	<TR>
		<TD><%= courseDetails.getInt("courseNumber") %></TD>
		<TD><%= courseDetails.getString("courseName") %></TD>
		<TD><%= courseDetails.getString("officeHr")%></TD>
		<TD><%= courseDetails.getString("TAs") %></TD>
		<TD><%= courseDetails.getBlob("courseSyllabus") %></TD>
		<TD><%= courseDetails.getString("firstName") + " " + courseDetails.getString("lastName") %></TD>
	</TR>
	<% } %>
</table>
<% } else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>