<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="Menu.jsp" %>
</head>
<%@ page import="java.sql.*" %>
<body>
<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){

 %>
<table>
	<tr>
		<td>Course Number</td>
		<td>Course Name</td>
	</tr>

<%
ResultSet result = (ResultSet)request.getAttribute("viewCourses");
if(result.first()) {
  %>
<TR>
    <TD> <%= result.getString("courseNumber") %></TD>
    <TD> <%= result.getString("courseName") %></TD>
</TR>
</table>
<% } } else{ %>

Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal">Login Page</a></div>
<%} %>

</body>
<%@ include file="Footer.jsp" %>
</html>