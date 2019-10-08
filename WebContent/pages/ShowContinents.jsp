<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListaContinenti</title>
</head>
<body>

	<h1>Lista Continenti:</h1>
	<c:forEach items="${continenti}" var="continent">
		<p><a href="ListaNazioni?continentSel=${continent}">${continent}</a></p>
	</c:forEach>

</body>
</html>