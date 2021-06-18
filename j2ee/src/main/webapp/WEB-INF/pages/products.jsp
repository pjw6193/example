<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- taglib directive to import the core tag library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL - Java Standard Tag Library</title>
</head>
<body>
	<%
	// JSP is-a Servlet (under the hood)
	// scriptlets are difficult for non-Java developers
	// ANT - another neat tool
	// looks for jars in /WEB-INF/lib
	// OR Maven - add the JSTL 1.2 dependency to POM
	%>
	<h1>Products</h1>
	<table>
		<tr>
			<th>Product Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Category</th>
		</tr>

		<!-- repeat this for each product -->
		<!-- var is temp variable for each iteration -->
		<!-- items is a collection available in scope -->
		<!-- for(Product product : product_list) -->
		<c:forEach var="product" items="${product_list}">
			<tr>
				<td><c:out value="${product.name}" /></td>
				<td>${product.description}</td>
				<td><c:out value="${product.price}" /></td>
				<td><c:out value="${product.category.name}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>


