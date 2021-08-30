<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Hello Faculty, You can Post or Edit Course Details here.</h1>

<table>
	<tr>
		<td>Office Hour</td>
		<td><input type="text" name="officeHr"></td>
	</tr>
	<tr>
		<td>TAs</td>
		<td><input type="text" name="TAs"></td>
	</tr>
	<tr>
		<td>Course Syllabus</td>
		<td><input type="file" name="syllabus"></td>
	</tr>
</table>
</body>

<%@ include file="Footer.jsp" %>
</html>