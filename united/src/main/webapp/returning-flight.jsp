<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Returning Flight</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<h1>Select Returning Flight</h1>
		<!-- 12-column grid system: responsive design: mobile/tablet/desktop/screen resolutions -->
		<div class="row">
			<div class="col-1" style="background-color: red"></div>
			<div class="col-11" style="background-color: blue">United</div>
		</div>

		<form method="post" action="returning-flight">
			<table class="table table-hover">
				<tr>
					<th>Flight Number</th>
					<th>Airline</th>
					<th>From</th>
					<th>To</th>
					<th>Depart Date</th>
					<th></th>
				</tr>
				<c:forEach var="flight" items="${flightData}">
					<tr>
						<td><c:out value="${flight.flightNumber}"></c:out> <input type="radio"
							name="selected-returning-flight-number" value="${flight.flightNumber}"></td>
						<td><c:out value="${flight.airline}"></c:out></td>
						<td><c:out value="${flight.fromAirport}"></c:out></td>
						<td><c:out value="${flight.toAirport}"></c:out></td>
						<td><c:out value="${flight.departure}"></c:out></td>
						<td><input type="submit" value="Select"
							class="btn btn-primary" /></td>
					</tr>
				</c:forEach>
			</table>
		</form>

	</div>
</body>
</html>