<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reserve a Resource by giving date and time</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
</head>

<body>
	<h2>Faculty/Staff/Student can reserve a resource here.</h2>

<script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
 </script>
 	<% 
  if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
%>
<form method="post" action="ReserveResource" >
	<p>Enter a resource : <input type="text" name="resourceName"></p>
	<p>Date : <input type="text" id="datepicker" name="reserveDate"></p>
	<p>Time Slot : <select name="timeSlot">
		<option name="1">2PM to 3 PM</option>
		<option name="2">6AM to 9 AM</option>
		<option name="3">12PM to 3PM</option>
		<option name="4">4PM to 6PM</option>
	</select></p>
<p><input type="submit" value="Submit"></p>
</form>
<% } else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>

<%@ include file="Footer.jsp" %>
</html>