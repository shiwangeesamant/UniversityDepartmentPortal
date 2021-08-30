<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="Menu.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ page import="java.sql.*" %>
</head>
<body>
<h2> Edit Alumni Information</h2>
<% 
	if(request.getSession().getAttribute("isUserLoggedIn")=="true") {
		
		String role = (String) session.getAttribute("roleValue");
		if(role.equals("Faculty") | role.equals("Staff")) { 
	%>
<form action="EditAlumniInfo" method="post">
<table>
	<tr>
				<td>Enter the alumni name for whom you want to edit the info. </td>
				<td><input type="text" name="alumniName"></td>
			</tr>
			<tr>
				<td>Program Taken</td>
				<td><select name="programTaken">
					<option value="">Select</option>
					<option value="BS">BS</option>
					<option value="MS">MS</option>
					<option value="Ph.D">Ph.D</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Major</td>
				<td><input type="text" name="major"></td>
			</tr>
			<tr>
				<td>Year Of Passed Out</td>
				<td><input type="text" name="passedOutYear"></td>
			</tr>
			<tr><td><input type="submit" value="Submit"></td></tr>
		</table>	
</form>	
<% } else { %>
	Sorry you are not a Faculty. Only faculty can edit the information for alumni.
<%} } else { %>
	Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<% } %>
</body>
</html>