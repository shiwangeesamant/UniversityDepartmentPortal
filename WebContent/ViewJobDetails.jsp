<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.sql.*" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Job details</title>
<%@ include file="Menu.jsp" %>
</head>
<body>
<script type="text/javascript">
function myDoc() {
	window.location.href='ApplyJob.jsp';
} 
</script>
<h2>List of job requirements posted in university site.</h2>
<% if(request.getSession().getAttribute("isUserLoggedIn")=="true"){ %>
<table cellspacing="15">
	<tr>
		<th>Job Id</th>
		<th>Job Role</th>
		<th>Job Content</th>
		<th>Posted By</th>
	</tr>
	
	<% ResultSet postedJob = (ResultSet) request.getAttribute ("jobDetails");
		while(postedJob.next()) {
	%>
	<TR>
		<TD><%= postedJob.getString("jobId") %></TD>
		<TD><%= postedJob.getString("jobRole") %></TD>
		<TD><textarea rows="10" cols="10" ><%= postedJob.getString("jobContent") %></textarea></TD>
		<TD><%= postedJob.getString("firstName") + " " + postedJob.getString("lastName") %></TD></TD>
	</TR>
	<% } %>
</table>
<p><input type="submit" value="Apply for job" onclick="myDoc()">
<% } else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>