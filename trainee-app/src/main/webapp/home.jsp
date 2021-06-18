<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	// javascript
</script>
</head>
<body>
<fmt:formatNumber currencyCode="USD" type="currency" value="1000000.58"></fmt:formatNumber>
Welcome home, ${user_principal}.
<!-- look for whatever full url handles a 'route' -->
<a href="<c:url value="/trainee"></c:url>">View All Trainees</a>
</body>
</html> 