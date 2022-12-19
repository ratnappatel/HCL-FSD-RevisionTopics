<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Product List</h1>
	<table border=3 style="border-color:green">
		<tr><th>Product id</th><th>Product Name</th><th>Category</th>
		<th>Quantity</th><th>Price</th><th>Buying Price</th></tr>
		 <c:forEach var="p" items="${prds}">
                <tr>
                    <td><c:out value="${p.id}" /></td>
                    <td><c:out value="${p.name}" /></td>
                    <td><c:out value="${p.category}" /></td>
                    <td><c:out value="${p.qty}" /></td>
                    <td><c:out value="${p.price}" /></td>
                    <td><c:out value="${p.buyingPrice}" /></td>
                </tr>
            </c:forEach>
		
	</table>
	<%
	String name=(String)session.getAttribute("name");
	out.println(name+"Would you like to ");
	%>
	<a href="http://localhost:9099/Ratna_GradedProject4ODS11/logout">Logout</a>
</body>
</html>