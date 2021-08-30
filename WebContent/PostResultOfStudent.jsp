<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.sql.*" %>
<head>
<%@ include file="Menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Post Result of Student's</title>

</head>

<body>
	<% 
	if(request.getSession().getAttribute("isUserLoggedIn")=="true") {
		String role = (String) session.getAttribute("roleValue");
		if(role.equals("Faculty")) { 
	%>
<form method="post" action="PostResultOfStudent" >	
	<table cellpadding="15" cellspacing="10">
		<tr>
			
			<th>Student Id</th>
			<th>Name of Exam</th>
			 <th>Student Result</th>
			<th>Select</th>
		</tr>
		<%
		ResultSet examDetails = (ResultSet) request.getAttribute("studentExam");
			while(examDetails.next()) {
				String examId= examDetails.getString("stuExamId") ;
				String examName = examDetails.getString("examName");
		%>	
		<!-- <tr><td><input type="checkbox" name="selectedItem"></td></tr> -->
		<tr>
			
			<%--  <td><input type="checkbox" name="stuExamId" value="<%= examDetails.getString("stuExamId")%>"><%= examDetails.getString("stuExamId")%></td>
			<td><input type="checkbox" name="examName" value="<%= examDetails.getString("examName")%>"><%= examDetails.getString("examName") %></td> --%>
			
			<td id="stuId" value="<%= examDetails.getString("stuExamId")%>" name="stuExamId"> <%= examDetails.getString("stuExamId")%></td>
			<td id="examName" value="<%= examDetails.getString("examName")%>" name="examName"> <%= examDetails.getString("examName")%></td>
			<!-- <td><input type="text" id="examresult" name="studentResult" ></td> -->
			<!-- <td><input type="submit" value="Post Result" onclick="myFunction()"></td> -->
			
			
			 <td><select id="examresult" name="Result">
					<option value="">Select</option>
					<option value="Grade A+">Grade A+</option>
					<option value="Grade A"> Grade A</option>
					<option value="Grade B">Grade B</option>
					<option value="Grade B-">Grade B-</option>
					<option value="Grade C">Grade C</option>
					<option value="Fail">Fail</option>
			</select></td> 
			
			<td><input type="submit" value="Post Result" id="bttHello"></td>
		</tr>
		<% } %>
		
		<!-- <tr><td><input type="submit" value="Post Result"></td></tr> -->
	</table>
	
	<!-- Faculty can post result for student by giving student id and exam name here.
	<table>
		<tr>
			<td>Student Id</td>
			<td><input type="text" name="stuExamId"></td>
		</tr>
		<tr>
			<td>Exam Name</td>
			<td><input type="text" name="examName"></td>
		</tr>
		<tr>
			<td><select name="Result">
					<option value="">Select</option>
					<option value="Grade A+">Grade A+</option>
					<option value="Grade A"> Grade A</option>
					<option value="Grade B">Grade B</option>
					<option value="Grade B-">Grade B-</option>
					<option value="Grade C">Grade C</option>
					<option value="Fail">Fail</option>
			</select></td></tr>
			<tr><td><input type="submit" value="POst Result"></td></tr>
	</table> -->
	<span id="result1"></span>
	</form>
	<% } else { %>
	<h2>Only Faculty can post results for students.</h2>
	<% } } else { %>
	Your Session is Expired please login again
<div><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Page</a></div>
<% } %>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js">
/*  function myFunction() {
	var studentId = document.getElementById('stuId').innerHTML;
	var examName = document.getElementById('examName').innerHTML;
	var studentResult = document.getElementById('examresult').value;
} */
 
 $(document).ready(function() {
	 $('#bttHello').click(function() {
		 //var stuId = $('#stuId').innerHtml;
		 // var examName = $('#examName').innerHtml;
		 var stuId = document.getElementById('stuId').innerHTML;
			var examName = document.getElementById('examName').innerHTML;
		 
		 var examresult = $('#examresult').val();
		 
		 $.ajax({
			 type: 'POST',
			    url: 'PostResultOfStudent',
			    data: {
			    	stuId:  tuId,
			    	examName: examName,
			    	examresult: examresult
			    },
			    success: function(result){
			    	$('#result1').html(result);
			    }
			    
			});​ 
	 });
 });
 
</script>
</html>