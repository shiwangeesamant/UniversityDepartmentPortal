<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cancel Resource</title>
</head>
<body>
	<%
	if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
	%>
<form action="CancelResource" method="post">
<h2>You can cancel your reservation here by giving resource name.</h2><br>
<p>Resource Name : <input text="text" name="resourceName"></p>
<p><input type="submit" value="Cancel Your Reservation !"></p>
</form>
<% } else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>