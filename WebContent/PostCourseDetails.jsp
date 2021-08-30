<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Faculty Submits Course Details </title>
<%@ include file="Menu.jsp" %>
</head>
<%@ page import="java.sql.*" %>
<body>

<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){ 
	String role = (String) session.getAttribute("roleValue");
	if(role.equals("Faculty")) {
		
		
%>

<h2>Faculty can post office hours, TAs and course syllabus for every course listed for them.</h2>
<form method="post" action="FacultyCourseDetails" enctype="multipart/form-data">

<table>
	<tr>
		<td>Course Name</td>
		<td><input name="courseName" type="text" ></td>
	</tr>
	<tr>
		<td>Office Hour</td>
		<td><input type="text" name="officeHr"></td>
	</tr>
	<tr>
		<td>TAs</td>
		<td><input type="text" name="TAs"></td>
	</tr>
	 <tr>
		<td>Course Syllabus</td>
		<td><input type="file" name="courseSyllabus"></td>
	</tr> 
	<tr><td><input type="submit" value="POST"></td></tr>
</table>
</form>
<% } else {
%> Only Faculty can post the details of course.	
<% } } else { %>

Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<% } %>
</body>

<%@ include file="Footer.jsp" %>
</html>