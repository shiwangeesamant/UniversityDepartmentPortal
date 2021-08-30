<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%-- <%@ include file="Menu.jsp" %> --%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page for User</title>
</head>

<body>
<h2 align="center">Welcome to Login Page</h2><br>

	<form method ="post" action="LogInSearch">
      <table>
        <tr>
           <td>User's NetId : </td>
           <td><input type="text" name="netId"></td>
        </tr>
        
        <tr>
           <td>User's Password : </td>
           <td><input type="password" name="passWord"></td>
        </tr>
        
      </table><br>
      <input type="submit" value="Login">
    
    </form>

</body>
<%@ include file="Footer.jsp" %>
<!-- <p>If you don't have a user Id and password, then</p>
<div><a href="http://localhost:8080/EmployeeDatabase/RegistrationForm.jsp"> Register Here</a></div> -->
</html>