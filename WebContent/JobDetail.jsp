<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create and View Job Postings</title>
<%@ include file="Menu.jsp" %>
</head>
<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
%>
<body>
<h2>Faculty and Staff can create/view job details here.</h2>

<p><a href="http://localhost:8080/UniversityDeptPortal/CreateJob.jsp">Create a Job here.</a><p>
<a href="http://localhost:8080/UniversityDeptPortal/ViewJobDetails">View Job Details.</a>
</body>
<% } else {%>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</html>