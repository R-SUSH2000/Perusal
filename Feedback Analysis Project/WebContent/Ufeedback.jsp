<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import ="com.feedback.DAO.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UserFeedbackServlet" method="get">
	<input type="hidden" name= "emailID" value = "<%=request.getParameter("emailID") %>">
	<br>Gender <br>
	 
	Male <input type="radio" value="Male" name ="gender">
	Female <input type="radio" value="Female" name="gender"> <br> <br>
	
	Clear Pricing i:e proper breakdown of the Amount Charge :- <br>
	Yes <input type="radio" value="Yes" name ="amount">
	No <input type="radio" value="NO" name ="amount"> 
	<br><br>
	Was the Interface userfriendly ?:- <br>
	Yes <input type="radio" value="Yes" name="userInterface">
	No <input type="radio" value="No" name="userInterface" ><br><br>
	 	
	If a complains was raised how quick was is resolved? <br>
	Within 1hr <input type="radio" value="Within 1hr" name="issuesolution"> 
	Within 5 hrs <input type="radio" value="Within 5 hrs" name="issuesolution"> 
	Within a day <input type="radio" value="Within a day" name="issuesolution"> <br> <br>
	
	Any additional features that you would like to see in our site in Future -  
	<input type="text" name="suggestion"><br><br>
	<input type="submit" value="Enter">
	</form>
	
</body> 
</html>