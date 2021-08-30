<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create a Discussion Topic</title>
<%@ include file="Menu.jsp" %>
</head>
<body>
<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
	
	String role = (String) session.getAttribute("roleValue");
	if(role.equals("Faculty") | role.equals("Staff")) {
		
%> 
<form method="post" action="CreateDiscussionTopic">
	<h1><b> Welcome to Discussion Page.</b></h1>
	<p><h2>You can create a new discussion topic by giving the name.</h2></p>
	<table>
		<tr>
			<td>Discussion Id</td>
			<td><input type="text" name="topicId"></td>
		</tr>
		<tr>
			<td>Enter a Discussion Topic</td>
			<td><input type="text" name="topicName"></td>	
		</tr>
        <tr><td><input type="submit" value="Enter"></td></tr>
	</table>
</form>
<% } else { %>
<p><b>Sorry, You are a student.</b> <br>
Onle Faculty and Staff can create a discussion topic. But you can post something about that topic.</p>
<%} } else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<% } %>
</body>
<%@ include file="Footer.jsp" %>
</html>