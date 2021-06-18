<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trainees</title>
</head>
<body>
<c:if test="${trainee_list ne null }">
	
	<h1>Trainee List</h1>
	<c:forEach var="trainee" items="${trainee_list}">
		<h2><c:out value="${trainee.name}" /></h2>
		<p>Major : <c:out value="${trainee.major}" /></p>
	</c:forEach>

</c:if>
</body>
</html>