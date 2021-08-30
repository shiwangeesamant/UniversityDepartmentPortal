<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="Menu.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Student's Results</title>
<%@ page import="java.sql.*" %>
</head>
<body>
<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){

%>
 <table cellspacing="10">
 	<tr>
 		<th>Student Id</th>
 		<th>Student Name</th>
 		<th>Exam Name</th>
 		<th>Exam Result</th>
 	</tr>
 	<% 
 		ResultSet examDetails = (ResultSet) request.getAttribute("results");
 		if(examDetails.first()) {
 	%>
 	<TR>
 		<TD><%= examDetails.getString("netId")  %></TD>
 		<TD><%= examDetails.getInt("firstName") + " " + examDetails.getInt("lastName") %></TD>
 		<TD><%= examDetails.getString("examName")  %></TD>
 		<TD><%= examDetails.getString("studentResult")%>
 	</TR>
 	<% } %>
 </table>	
 <% } else {%>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>
<%@ include file="Footer.jsp" %>