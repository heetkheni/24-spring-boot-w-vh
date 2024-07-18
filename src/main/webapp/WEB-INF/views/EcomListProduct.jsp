<%@page import="com.bean.EProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% List<EProductBean> products = (List<EProductBean>) request.getAttribute("products"); %>
	

	<h2>List Products</h2>

	<a href="newproduct">New Product</a><br><br>

	
	
	<table border = "1">
	<tr>
			<th>ProductId</th>
			<th>ProductName</th>
			<th>Action</th>
		</tr>
		
	<%
	for(EProductBean p : products){
		out.print("<tr>");
		out.print("<td>" + p.getProductId() +"</td><td>" + p.getProductName() + "<td><a href='deleteproduct?productId="+p.getProductId()+"'>Delete</a> | <a href='viewproduct?productId="+p.getProductId()+"'>View</a></td>" );
		out.print("</tr>");
	}
	%>
		
	<tr>
	<td>
	</td>
	</tr>
	
	
	</table>
	
	

</body>
</html>