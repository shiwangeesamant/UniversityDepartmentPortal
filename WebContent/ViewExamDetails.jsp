<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.sql.*" %>
<head>
<%@ include file="Menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Exam Details</title>
</head>
<body>
<h2 align="center">Student can register for exam here.</h2>
<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
	
	String role = (String) session.getAttribute("roleValue");
	if(role.equals("Student")) { 

%>
<form action="RegisterForExam" method="post">
<div style="color: #FF0000;"> ${ErrorMsg}</div>
<table cellspacing="10">
	<tr>
		<th>Exam Details</th>
		<!-- <th>Exam Date</th> -->
		<th>Student Id</th>
	</tr>
	<% ResultSet examDetails = (ResultSet) request.getAttribute("examDetails");
		/* while(examDetails.next()) { */
	%>
	<tr>
		<td><select name="examName">
				 <% while(examDetails.next()) { %> 
				<option value="<%= examDetails.getString("examName") %>"><%= examDetails.getString("examName") %></option>
				 <% } %>
		</select>    </td>
		
		<td><input type="text" name="studentId"></td>
	</tr>
	
<tr><td><input type="submit" value="Register for Exam" onclick="myFunction()"></td></tr>	 
</table>

</form>
<script type="text/javascript">
	function myFunction() {
			alert("Student has registered successfully with student Id as " + studentId);
		}
	
</script>
<% } else { %>
Only Student can register for exam.
<% } } else {%>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>