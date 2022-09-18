<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="centre">
<h1>Login</h1>
<form action="LoginServlet" method="get" >
<table> 
	<tr> <td>Enter the Email ID : <input type="text" name ="emailID"></td></tr>
	<tr> <td>Enter the password : <input type="password" name="pass"></td> </tr>
	<tr> <td> <input type="submit" value = "Login"></td></tr>
</table> 
 </form>
 <from action="NewUserServlet" method="get">
 <table><tr><td><input type="submit" value = "Register"></td></tr>
 </table>
 </from>
 </div>
</body>
</html>