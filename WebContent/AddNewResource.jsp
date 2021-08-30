<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="Menu.jsp" %>
</head>
<body>
<h1>You can create a new resource here.</h1>
<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
	
	/* HttpSession session = request.getSession(); */
	String role = (String) session.getAttribute("roleValue");
	if(role.equals("Staff") | role.equals("Faculty")) {
%>
You can create a new resource here.	


<form method="post" action="StaffServices">
<table>
	<tr>
		
		<td>Resource Name</td>
		<td><input type="text" name="resourceName"></td>
	</tr>
	<tr>
		<td>Time Slot</td>
		<td><input type="text" name="timeSlot"></td>
	</tr>	
	
</table>
	<input type="submit" value="Submit the Resource">
</form>	
<% } else {
%> Sorry, You are not a staff or faculty. Only Staff and faculty can create a new resource.	
<% } } else { %>

Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<% } %>
</body>
<%@ include file="Footer.jsp" %>
</html>