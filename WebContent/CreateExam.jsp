<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create New Exam</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
</head>
<body>
<script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>

<h2>Faculty can post a new exam here !</h2>
<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
	
	String role = (String) session.getAttribute("roleValue");
	if(role.equals("Faculty")) {

%>
<form method="post" action="CreateExam">
<table>
	<tr>
		<td>Exam Name :</td>
		<td><input type="text" name="examName">
	</td></tr>
	<tr>	
		<td>Exam Date :</td>
		<td><input type="text" id="datepicker" name="examDate"></td>
	</tr>
	<tr><td><input type="submit" value="Submit"></td></tr>	
</table>
</form>
<% } else {
%>Sorry, you are not a faculty. Only Faculty can post exam.	
<% } } else { %>

Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<% } %>
</body>

<%@ include file="Footer.jsp" %>
</html>