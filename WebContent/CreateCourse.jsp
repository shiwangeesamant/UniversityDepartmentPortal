<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Course</title>
<%@ include file="Menu.jsp" %>
</head>
<body>

<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
	
	String role = (String) session.getAttribute("roleValue");
	if(role.equals("Faculty")) {

%>
<h2 align="center"> Faculty can create course.</h2>
<form method="post" action="CreateCourseByFaculty">
<table>
	<!-- <tr><td><input type="hidden" name="logInDetails" value=${requestScope.logInDetails}></td></tr> -->
	<tr>
		<td>Course Number : </td>
		<td><input type="text" name="courseNumber"></td>
	</tr>
	<tr>
		<td>Course Name : </td>
		<td><input type="text" name="courseName"></td>
	</tr>	
	<tr><td><input type="submit" value="Submit the Course"></td></tr>
</table>	</form>
<% } else {
%> Sorry, You are not a Faculty. Only Faculty can create a course.	
<% } } else { %>

Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<% } %>

</body><br/>

<%@ include file="Footer.jsp" %>
</html>