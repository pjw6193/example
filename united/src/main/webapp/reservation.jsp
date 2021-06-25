<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Start Your Reservation Today!!</title>
</head>
<body>

<form method="post" action="initializeReservation">
	From: <input type="text" name="fromAirport" />
	Date: <input type="date" name="departDate" />
	<br/>
	To: <input type="text" name="toAirport" />
	Date: <input type="date" name="arrivalDate" />
	<input type="submit" />
</form>

</body>
</html>