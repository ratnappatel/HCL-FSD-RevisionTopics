<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>You are on User Page 2</h1>
<h2>
Welcome 
	<%
			String name=(String)session.getAttribute("name");
	out.println(name);
		%>
	</h2>
	<form action="userPage.jsp">
		<input type=submit value="Go back to UserPage">
	</form>
	<a href="http://localhost:9099/Ratna_GradedProject4ODS/logout">Logout</a>
</body>
</html>