<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Menu.jsp" %>
<%@ page import="java.sql.*" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
%>	
<table>
	<tr>
	<th>Student Id</th>
	<th> Name</th>
	<th>Job Role</th>
	<th>Job Id</th>
</tr>

<%
		ResultSet jobResult = (ResultSet) request.getAttribute ("jobResult");
		  /* if(jobResult.first()) {  */
		%>
		
		
		<% if(jobResult.first()) { %>
		
		<tr>
		<td><%= jobResult.getString("netId") %></td>
		<td><%= jobResult.getString("firstName") + " " + jobResult.getString("lastName" )%></td>
		<td><%= jobResult.getString("jobRole") %></td>
		<td><%= jobResult.getString("jobId") %></td>
		</tr>
		<% }%>
</table>
<%} else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>