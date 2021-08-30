<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="Menu.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Announcement Page</title>
</head>
<body>
 <%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
	
	String role = (String) session.getAttribute("roleValue");
	if(role.equals("Faculty") | role.equals("Staff")) {
		
%> 
<form method="post" action="PostAnnouncements">
<h1>Only Faculty and Staff can see the announcement page.</h1>
<h2> Post an Announcement </h2>
		<table>
		<tr>
			<td><p>Give Announcement Id</p></td>
			<td><input type="text" name="announcementId"></td>
		</tr>
		<tr>
		<td><p>Write your announcement</p></td>	
		<td><textarea rows="4" cols="50" name="announceText"></textarea></td>
		</tr>
		
		
		<tr><td><input type="submit" value="Post Announcement"></td></tr>
		</table>
		

</form>
<% } else { %>
<p>Sorry, Students can't get access to announcement page.</p>
<%} } else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body> <br/>
<%@ include file="Footer.jsp" %>
</html>