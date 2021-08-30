<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(request.getSession().getAttribute("isUserLoggedIn")=="true"){ %>
<form action="ApplyForJob" method="post">
<table>
	<tr>
	<td>Job role</td>
	<td><input type="text" name="jobRole"></td>
	</tr>
	
	<tr>
	<td>Job Id</td>
	<td><input type="text" name="jobId"></td>
	</tr>
	
	
	<tr><td><select name="job">
				<option value="">Select</option>
				<option value="">Apply</option>
				</select></td></tr>
<tr><td><input type="submit" value="Apply for job"></td></tr>
</table></form>
<% } else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>