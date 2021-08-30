<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%@ page import="java.sql.*" %>
<%@ include file="Menu.jsp" %>
<body>
<script>
function newDoc() {
    window.location.assign("https://weblogin.albany.edu/idp2/Authn/UserPassword")
}
</script>
<% 
  if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
	  
	  ResultSet roleFaculty = (ResultSet) request.getAttribute ("roleFaculty");
	   
  
%>
 <h2> Professor's name with their email address.</h2>
 

<table cellspacing="15">
	<tr>
	<th>Professor Name</th>
	<th>Email Address</th>
	</tr>
	
		<% if(roleFaculty.first()) {%>
			<tr>
				<td><%= roleFaculty.getString("firstName") + " " + roleFaculty.getString("lastName") %></td>
				<td><%= roleFaculty.getString("emailId") %> </td>
			</tr>
			<% while(roleFaculty.next()) { %>
				<tr>
				<td><%= roleFaculty.getString("firstName") + " " + roleFaculty.getString("lastName") %></td>
				<td><%= roleFaculty.getString("emailId") %> </td>
			</tr>
			<%} }%>
</table>
<br>
<p>
To send an email to professor, type his/her email addresss here : <input type="text" name="emailId"></p>
<p><input type="submit" onclick="newDoc()"></p>
<% } else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>