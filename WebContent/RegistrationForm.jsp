<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="Header.jsp" %>
<%-- <%@ include file="Menu.jsp" %> --%>
<style>
.right {
	position: absolute;
	right: 150px;
	margin: auto;
    width: 200px;
    border: 3px solid #73AD21;
    padding: 10px;
}
</style>
<script type="text/javascript" >

  function showField(name) {
    if(name=='Student')document.getElementById('div1').style.display="block";
    else document.getElementById('div1').style.display="none";
  }
  function hideField() {
	  document.getElementById('div1').style.display='none';
  }
  
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration Page</title>

</head>
<h2 align="center" style="color:red">Welcome to Registartion Page of University</h2>
<h3>Hello User, Please give your details for registration.</h3>
<body onload="hideField()">
<div class="right">
	<h3>Already Registered ?</h3>
	<h4><a href="http://localhost:8080/UniversityDeptPortal/LoginPage.jsp">Login Here</a></h4>
</div>
	
<form method ="post" action="RegisterUser">
	<div style="color: #FF0000;"> ${ErrorMsg}</div>
	<div style="color: #FF0000;"> ${LogOutMessage}</div>
    <table>
    
    	<tr>
           <td>NetId : </td>
           <td> <input id="netId" type="text" name="netId" required></td>
        </tr>
        
        <tr>
           <td>Password :</td>
           <td><input id="passWord" type="password" name="passWord" required></td>
        </tr>
    	<tr>
    		<td>First Name : </td>
    		<td><input id="firstName" type="text" name="firstName" required></td>
    		
    	</tr>
    	<tr>
    		<td>Last Name : </td>
    		<td><input id="lastName" type="text" name="lastName" required></td>
    		
    	</tr>
    	<tr>
    		<td>Email Address</td>
    		<td><input type="text" name="emailId"></td>
    	</tr>
         <tr>
        	<td>User's Role : </td><td><select name="Role" onchange="showField(this.options[this.selectedIndex].value)">
        								<option value="Select">Select</option>
        								<option value="Student">Student</option>
        								<option value="Faculty">Faculty</option>
        								<option value="Staff">Staff</option>
        							</select></td>
        							
        							<td><div id='div1'> <label>Year Joined the Progarm : </label><input id="yearOfJoining" type="text" name="yearOfJoining">
        							<label>Program : <select  name="programTaken" multiple>
        							
        															
        															<option value="BS">BS</option>
        															<option value="BA">BA</option>
        															<option value="MS">MS</option>
        															<option value="Ph.D">Ph.D</option>
        														</select></label></div></td>
      </tr> 
      <tr><td><input type="submit" value="Register"></td></tr>
    </table>
    
  </form>   

</body>
</br>
</br>
<%@ include file="Footer.jsp" %>

</html>