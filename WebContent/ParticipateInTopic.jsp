<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Participate In Discussion Topic</title>
</head>
<body>
<h2>Participate in discussion topic by giving discussion Id</h2>
<% 
  if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
	  
%>
<form action="ParticipateInDiscussion" method="post">
<table>
	<tr>
		<td>Discussion Id</td>
		<td><input type="text" name="topicId"></td>
	</tr>
	<tr>
		<td>Discussion Content</td>
		<td><textarea rows="20" cols="10" name="topicContent"></textarea></td>
	</tr>
	
</table>
<input type="submit" value="Submit">
</form>
<% } else {%>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>