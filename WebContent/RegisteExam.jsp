<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="Menu.jsp" %>
<%@ page import="java.sql.*" %>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(request.getSession().getAttribute("isUserLoggedIn")=="true"){ 
	String role = (String) session.getAttribute("roleValue");
	if(role.equals("Student")) {
%>
<h2 align="center">Student can register exam here.</h2>
<form action="StudentRegisterExam" method="post">
<table cellspacing="10">
	<tr>
		<th>Select One Exam</th>
		<th>Exam Name</th>
		<th>Exam Date</th>
	</tr>
	<% ResultSet examDetails = (ResultSet) request.getAttribute("examDetails");
		while(examDetails.next()) {
	%>
	<tr>
		<td><input type="checkbox">
		<td><%= examDetails.getString("examName") %></td>
		<td><%= examDetails.getString("examdate") %></td>
	</tr>
	<% } %>	
</table>
</form>
<%} else { %>
<p>Only student can register for a exam.</p>
<% } } else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>