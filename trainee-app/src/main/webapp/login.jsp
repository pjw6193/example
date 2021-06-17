<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Here</title>
</head>
<body>
<%
 	// java code in my html. scriptlet
 	// implicit objects: request, out
 	if(request.getAttribute("login_error") != null){
 		// print the error message
 		out.print(request.getAttribute("login_error"));
 	}
%>
	<form method="post" action="login">
		<div>
			<label>Username:</label>
			<input type="text" name="user_username" />
		</div>
		<div>
			<label>Password:</label>
			<input type="password" name="user_password" />
		</div>
		<div>
			<input type="submit" value="Login" />
		</div>
	</form>

</body>
</html>