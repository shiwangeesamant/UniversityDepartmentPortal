<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ include file="Menu.jsp" %>
<%@ page import="java.sql.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Student Status Here</title>
</head>
<body>
<h2>View student details by logged in student.</h2>

<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
%>	

	<table cellpadding="15">
		<tr>
			<th>Student netId </th>
			<th>Student Name</th>
			<th>Year of Joining</th>
			<th>Program Taken</th>
			<th>Major</th>
			<th>No. of Semester</th>
			<th>Is she/he a candidate ?</th>
		</tr>
		  <%
		ResultSet studentDetails = (ResultSet) request.getAttribute ("loggedInStudent");
		if(studentDetails.first()) {
		%>
		<tr>
			<td><%= studentDetails.getString("netId") %></td>
			<td><%= studentDetails.getString("firstName") + " " +  studentDetails.getString("lastName") %></td>
			<td><%= studentDetails.getInt("yearOfJoining") %></td>
			<td><%= studentDetails.getString("programTaken") %></td>
			<td><%= studentDetails.getString("major") %></td>
			<td><%= studentDetails.getString("noOfSemester") %></td>
			<td><%= studentDetails.getString("studentStatus") %></td>
		</tr>
		 <% } %> 
	</table>

<%} else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
<%@ include file="Footer.jsp" %>
</html>