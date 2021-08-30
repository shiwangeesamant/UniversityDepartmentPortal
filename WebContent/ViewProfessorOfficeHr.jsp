<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ViewProfessorOfficeHr</title>
</head>
<%@ page import="java.sql.*" %>
<%@ include file="Menu.jsp" %>
<body>
<h2>Student can view program taken by professor's and their office hour.</h2>
<table cellspacing="15" cellpadding="5">
<tr>
	<th><u>Proffesor Name</u></th>
	<th><u>Course Offered By Professor</u></th>
	<th><u>Office Hour</u></th>
	</tr>
	
	<% ResultSet officeHour = (ResultSet)request.getAttribute("officeHr");
		if(officeHour.first()) {
	%>
	<tr>
		<td><%= officeHour.getString("firstName") + " " + officeHour.getString("lastName") %></td>
		<td><%= officeHour.getString("courseName") %></td>
		<td><%= officeHour.getString("officeHr") %></td>
	</tr>
	<% while(officeHour.next()) { %>
	<tr>
		<td><%= officeHour.getString("firstName") + " " + officeHour.getString("lastName") %></td>
		<td><%= officeHour.getString("courseName") %></td>
		<td><%= officeHour.getString("officeHr") %></td>
	</tr>
	<% } } %>
</table>
</body>
</html>