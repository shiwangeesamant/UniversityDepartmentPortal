<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="Menu.jsp" %>
</head>
<%@ page import="java.sql.*" %>
<script type="text/javascript">

        function openPage() {
            window.location.href ="PostCourseDetails.jsp" ;
        }

    </script>

<body>
<h2 align="center">Only Faculties can see courses offered by them.</h2>

<% 
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){ 
	String role = (String) session.getAttribute("roleValue");
    if(role.equals("Faculty")) { %>
 <h2>Courses Offered By Logged In Faculty :</h2>
 <form action="PostCourseDetails.jsp" method="post">
    <table>
    	<tr>
    		<th>Course Name</th>
    	</tr>
    	<% ResultSet courseByFaculty = (ResultSet)request.getAttribute("course");
    		if(courseByFaculty.first()) { %>
    			<tr>
    			<td><input type="button" value=" <%= courseByFaculty.getString("courseName") %>" name="courseByFaculty" onclick="openPage()">
    		</td></tr>
    		<% while(courseByFaculty.next()){ %>
    		
    		<tr>
    			<td><input type="button" value=" <%= courseByFaculty.getString("courseName") %>" name="courseByFaculty" onclick="openPage()">
    			
    			<% String courseName = request.getParameter("courseByFaculty");
    			session.setAttribute("courseName", courseName); %>
    			
    			</td>
    		</tr>
    		<% } }%>	
    		<p>Click on the course name to submit the course details.</p>
    </table></form>
<% }  else { %>
<h2>You are not a Faculty. Only Faculties can see courses offered by them.</h2>
<% } } else {%>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<% } %>
</body>

</html>