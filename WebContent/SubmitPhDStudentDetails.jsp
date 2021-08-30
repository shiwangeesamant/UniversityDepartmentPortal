<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Home Page</title>
<%@ include file="Menu.jsp" %>
</head>
<body>
<h2>If you are a student, then you can submit your details here.</h2>

<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
	
	String role = (String) session.getAttribute("roleValue");
	if(role.equals("Student")) {
	

%>
<form method="post" action="SubmitPhDStudentDetails">
	<table>
		<tr>
			<td>No of Semester :</td>
			<td><input type="text" name="noOfSemester"></td>
		</tr>
		<tr>
			<td>Major : </td> 
			<td><input type="text" name="major"></td>
		</tr>
		<tr>
			<td>Student Status :<select name="studentStatus">
								<option value="">Select</option>
								<option value="A Candidate">Candidate</option>
								<option value="Not a candidate">Not a Candidate</option>
								</select> </td>
			
		</tr>
		<tr><td><input type="submit" value="Submit Your Details Here !"></td></tr>
	</table>
</form>

	<%} else { %>
	<h2>Sorry, You are not a Student. Only students can register their details.</h2>
<% } %>
<p><a href="http://localhost:8080/UniversityDeptPortal/ViewStudentStatus">View Student Details</a></p>
<% }else { %>
	Your Session is Expired please login again
	<div><a href="http://localhost:8080/UniversityDeptPortal">Login Page</a></div>
<%} %>
</body>
<%@ include file="Footer.jsp" %>
</html>