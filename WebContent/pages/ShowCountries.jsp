<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListaNazioni</title>
</head>
<body>

	<h1>Lista Nazioni:</h1>
	<c:forEach items="${nazioni}" var="nazione">
		<p>
			<a href="ListaCittà?code=${nazione.code}">${nazione.name}</a>
		</p>
	</c:forEach>
	

</body>
</html>