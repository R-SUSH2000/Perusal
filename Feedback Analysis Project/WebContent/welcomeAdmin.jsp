<%@page import="com.feedback.DAO.User"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AdminHomeServlet">
 
<h1>Welcome <%=request.getParameter("emailID")%> <br></h1>>
Current Time: <%=java.util.Calendar.getInstance().getTime()%> 

<br><br><br>

	<%
	ArrayList<User> list = (ArrayList<User>)request.getAttribute("pListf");
	%>
	<table border="6">
		<tr>
			<th>Name</th> <th>loginId</th> <th>password</th> <th>emailID</th> <th>role</th>
		</tr>
		<%
		for(User u:list){
				System.out.println(list.size());
		%>
		<tr>
		<td><%=u.getName()%></td> 
		<td><%=u.getLoginId()%></td> 
		<td> <%=u.getPassword()%></td>
		<td><%=u.getEmailID()%></td> 
		<td> <%=u.getRole()%></td>
		</tr>
		<% } //End of Loop %>
	</table>
	
		
</form>>
</body>
</html>