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
<h1>Register</h1>
<form action= "NewUserServlet" method="get">
<table>
	<tr><td>Enter the Name : <input type="text" name ="uname"></td></tr>
	<tr><td>Enter the Password : <input type="password" name ="pass"></td></tr>	
	<tr><td>Enter the Email ID : <input type="text" name ="emailID"></td></tr>
	<tr><td>Enter the role : <input type="text" name ="role"></td></tr>
	<tr> <td> <input type="submit" value = "Register"></td></tr>
</table>
</form>
</div>
</body>
</html>