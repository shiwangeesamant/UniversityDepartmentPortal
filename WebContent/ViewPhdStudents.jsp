<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <script type="text/javascript" >

  function showField() {
    document.getElementById('div1').style.display="block";
  }
  function hideField() {
	  document.getElementById('div1').style.display='none';
  }
  
</script> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="Menu.jsp" %>

</head>
<%@ page import="java.sql.*" %>
<body onload="hideField()">

<%
if(request.getSession().getAttribute("isUserLoggedIn")=="true"){
	
	String role = (String) session.getAttribute("roleValue");
	if(role.equals("Faculty")) {

%>
<h2 align="center">List of currently enrolled Ph.D students.</h2>
<form method="post" action="ViewPhdStudentDetailsByNetId">
<table>
	<tr>
		<th>Student's NetId</th>
		<th> Name</th>
	</tr>
<%
 ResultSet studentDetails = (ResultSet) request.getAttribute ("studentDetails");
   while(studentDetails.next()){
	//out.print("FIrst Record Present");
%>
	<TR>
    <TD> <input type="button" value="<%= studentDetails.getString("netId") %>" name="selectedNetId" onclick="window.location='ViewPhDStudentDetails.jsp'">
    	<%-- <% 
    		String NetId = request.getParameter("selectedNetId");
    		session.setAttribute("selectedNetId", NetId); %> --%>
    </TD>
    <TD><%= studentDetails.getString("firstName") + " " + studentDetails.getString("lastName")%></TD>
    	<!-- <TD><div id='div1' > <label>Year Joined the Progarm : </label></div></TD> -->
    </TR>
	<% }%>
</table>
</form>
	<% } else { %>
	<h2>Sorry, you are not a faculty. Only Faculties can see the page. </h2>
<% } } else { %>
Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<%} %>
	<script type="text/javascript">
		function myFunction() {
			String major = studentDetails.getString("Major")
		}
	</script>
</body>
<%@ include file="Footer.jsp" %>
</html>