<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
 import="java.util.List, java.util.ArrayList, com.gl.ods.model.Product"%>
    
    
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
		<%
			List<Product> prds=(ArrayList)session.getAttribute("prds");
		for(Product p:prds)
		{
		%>
		<tr>
			<td><%=p.getId() %></td>
			<td><%=p.getName() %></td>
			<td><%=p.getCategory() %></td>
			<td><%=p.getQty() %></td>
			<td><%=p.getPrice() %></td>
			<td><%=p.getBuyingPrice() %></td>
		</tr>
		<%} %>
		
	</table>
	<%
	String name=(String)session.getAttribute("name");
	out.println(name+"Would you like to ");
	%>
	<a href="http://localhost:9099/Ratna_GradedProject4ODS/logout">Logout</a>
</body>
</html>