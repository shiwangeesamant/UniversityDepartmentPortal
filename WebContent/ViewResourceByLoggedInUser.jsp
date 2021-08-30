<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reserved Resources by Logged In User</title>
</head>
<%@ page import="java.sql.*" %>
<%@ include file="Menu.jsp" %>
<body>
<% 
  if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
%>
<h2><u></u>Reserved Resources by Current User</u></h2><br>
<h3>If you have reserved a resource, then you can see here.</h3>
<table cellpadding="10">
		<tr>
			<th>User Name</th>
			<th> Resources</th>
		</tr>	
			<% 
				ResultSet reourceDetail = (ResultSet)request.getAttribute("reourceDetail");
					if(reourceDetail.first()){
			%>
			
			<TR>
			<TD><%= reourceDetail.getString("userName") %></TD>
			<TD><%= reourceDetail.getString("resourceName") %></TD>
			</TR>
			
			
			<%} %>
			
	</table><br>
	<input type="button" value="Click Here to Cancel a Resource !" border="10" onclick="window.location='CancelResource.jsp'">
	<% } else {%>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>