<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.sql.*" %>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Participates in Discussion Forum</title>
<%@ include file="Menu.jsp" %>
</head>
<body>

<form method="post" action="PostDiscussion"></form>
<h2 align="center">Students can participate in discussion board.</h2>
<h3>Please click on the topic id to participate.</h3>
<table cellspacing="10">
	<tr>
		 <th>Topic Id</th> 
		<th>Discussion Topic</th>
	</tr>
<%
 	ResultSet topics = (ResultSet) request.getAttribute ("topics");
   	while(topics.next()){	
%>	
	<TR>
		 <TD><%= topics.getString("topicId") %></TD> 
		<TD><textarea rows="3" cols="20"><%= topics.getString("topicName")%></textarea></TD>
	</TR>
	<% } %>
</table>
<div>Click Here to Participate in Discussion <input type="button" value="Click here!" onclick="window.location='ParticipateInTopic.jsp'"></div>
</body>
</html>