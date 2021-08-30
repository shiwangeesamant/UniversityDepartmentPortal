<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Ph.D Students</title>
<%@ include file="Menu.jsp" %>
</head>
<%@ page import="java.sql.*" %>
<%@ page import="org.project.dao.UserDao" %>
<body>
<h1>hello</h1>
<% 
	UserDao user = new UserDao();
   String NetId = request.getParameter("selectedNetId");
	//String selectedNetId = (String) session.getAttribute("NetId");
	ResultSet studentDetailsByNetId = user.StudentDetailsByNetId(NetId);
%>
<table>
	<tr>
		<th>Student's NetId</th>
		<th> Name</th>
	</tr>
 <%

   while(studentDetailsByNetId.next()){
	
%>
	<TR>
    	<TD> <%= studentDetailsByNetId.getInt("netId") %></TD>
    	<TD><%= studentDetailsByNetId.getString("firstName") + " " + studentDetailsByNetId.getString("lastName")%>></TD>	
    </TR>
<% }%> 
</table>

</body>

<%@ include file="Footer.jsp" %>
</html>