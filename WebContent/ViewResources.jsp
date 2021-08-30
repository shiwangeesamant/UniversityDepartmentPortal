<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View All the Resources</title>
<%@ page import="java.sql.*" %>
<%@ include file="Menu.jsp" %>
</head>
<body>
<% 
  if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
%>
	<table cellpadding="10">
		<tr>
			<th><u><font="20">Available Resources</font></u></th>
		</tr>	
			<% 
				ResultSet resources = (ResultSet)request.getAttribute("resources");
					while(resources.next()){
			%>
			
			<TR><TD><%= resources.getString("resourceName") %></TD></TR>
			
			
			<%} %>
			
	</table><br>
	<input type="button" value="Click Here to Resserve a Resource !" border="10" onclick="window.location='ReserveResource.jsp'">
	<% } else {%>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
</body>
</html>