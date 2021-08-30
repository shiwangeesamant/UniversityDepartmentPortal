<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ page import="java.sql.*" %>
<%@ include file="Menu.jsp" %>
<body>
<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){

%>
<h1>List of courses offered by department</h1>

  <table cellspacing="10">
   	<tr>
   		<th>Course Offered By</th>
   		<th>Course Number</th>
   		<th>Course Name</th>
   	</tr>
   	
 <%
	ResultSet viewCourses = (ResultSet)request.getAttribute("viewCourses");
 	if(viewCourses.first()) {
 		%>
 		<TR>
	<TD><%= viewCourses.getString("firstName") + " " + viewCourses.getString("lastName") %></TD>
    <TD> <%= viewCourses.getInt("courseNumber") %></TD>
    <TD> <%= viewCourses.getString("courseName") %></TD>
</TR>
<% 
	while(viewCourses.next()){
  %>	
<TR>
	<TD><%= viewCourses.getString("firstName") + " " + viewCourses.getString("lastName") %></TD>
    <TD> <%= viewCourses.getInt("courseNumber") %></TD>
    <TD> <%= viewCourses.getString("courseName") %></TD>
</TR>

<%} }%>
</table>
<% } else {%>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>

</body>

<%@ include file="Footer.jsp" %>
</html>