<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListaCittà</title>
</head>
<body>
	<h1>Lista Città:</h1>
	<c:forEach items="${listaCitta}" var="citta">
		<p>${citta.name} ---> Abitanti: ${citta.population}</p>
	</c:forEach>
	<div align="right" style="margin-down: 50px;">
		<form action="ListaNazioni" method = "post">
			<input type="submit" value="Indietro" />
		</form>
	</div>
</body>
</html>