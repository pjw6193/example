<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Server Pages - HTML page with Java code</title>
</head>
<body>
	<%-- JSP comments: stay server-side --%>
	<!-- HTML comment is sent back to the client browser -->
	
		<!-- request "scope" variable -->
	<h1>Welcome, ${authenticated_user}</h1>
	<p>
		<!-- session "scope" variable -->
		Your password is: ${user_password}
	</p>
	
</body>
</html>