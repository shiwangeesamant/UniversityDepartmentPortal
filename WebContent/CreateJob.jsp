<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Job</title>
<%@ include file="Menu.jsp" %>
</head>
<h2>Please give job details here.</h2>
<body>
<form action="CreateJobDetails" method="post">
	<table>
		<tr>
			<td>Job Id</td>
			<td><input type="text" name="jobId"></td>
		</tr>
		<tr>
			<td>Job Role</td>
			<td><input type="text" name="jobRole"></td>
		</tr>
		<tr>
			<td>Job Contents</td>
			<td><textarea rows="10" cols="15" name="jobContent"></textarea></td>
		</tr>
		<tr><td><input type="submit" value="Post Job"></td></tr>
	</table>
</form>
</body>
</html>