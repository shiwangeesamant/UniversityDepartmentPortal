<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Alumni Info</title>
<%@ page import="java.sql.*" %>
</head>
<body>
<h2>Fetching alummni information from database.</h2>
<table cellpadding="15">
	<tr>
		<th>Alumni Name</th>
		<th>Program Taken</th>
		<th>Major</th>
		<th>Year of Passed Out</th>
	</tr>
	<% 
		ResultSet alumniInfo = (ResultSet) request.getAttribute("alumniInfo");	
		while(alumniInfo.next()) {
	%>
	<TR>
		<TD><%= alumniInfo.getString("alumniName") %></TD>
		<TD><%= alumniInfo.getString("programTaken") %></TD>
		<TD><%= alumniInfo.getString("major") %></TD>
		<TD><%= alumniInfo.getInt("passedOutYear") %></TD>
	</TR>
	<%} %>	
	<tr><td>Click here to edit alumni info !  <input type="button" name="edit" value="Edit" onclick="javascript:window.location='EditAlumniInfo.jsp';"></td></tr>
	
</table>
</body>
</html>