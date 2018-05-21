<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="./style/style.css">
<!-- Bootstrap, Jquery -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Aplicación Gestión Docente</title>
</head>
<body>
<div id="contenedor">
		<ul class="nav nav-tabs nav-users loginsecretaria">
			<li class="nav-item "><a href="LogoutServlet">Salir</a></li>
		</ul>
	</div>
	<div class="container">
		<div class="page-header">
			<h3>REGISTRAR NUEVO PROFESOR</h3>
		</div>
		<%@ include file="FormNuevoProfesor.jsp"%>
	</div>
</body>
</html>