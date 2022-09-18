<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <body bgcolor="#ffffcc">
        <form action="show_data.jsp" method="get">
            <TABLE style="background-color: #ECE5B6;" WIDTH="50%">
                <tr width="100%">
                    <td >Student Name</td>
                    <td ><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td width="20%">Stream</td>
                    <td width="25%"><input type="radio" name="stream" 
                        value="B.Tech.">B.Tech.</td>
                    <td width="30%"><input type="radio" name="stream" value="MCA" 
					    checked>MCA</td>
                    <td width="25%"><input type="radio" name="stream" value="MBA">
					    MBA</td>
                </tr>
                <tr>
                    <td>Branch</td>
                    <td><input type="radio" name="branch" value="CS" checked>
					    CS</td>
                    <td><input type="radio" name="branch" value="IT"> IT</td>
                    <td><input type="radio" name="branch" value="EC"> EC</td>
                </tr>
                <tr>
                    <td>Course Type</td>
                    <td><input type="radio" name="course" value="Regular" checked>
					    Regular</td>
                    <td><input type="radio" name="course" value="Correspondance">
					    Correspondance</td>
                    <td><input type="radio" name="course" value="Online"> Online</td>
                </tr>
				<tr><td></td><td></td>
				<td><input type="submit" name="submit" value="submit"></td></tr>
            </TABLE>
        </form>

</body>
</html>