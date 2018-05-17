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
	<div class="contenedor barraUsuarios">
		<ul class="nav nav-tabs nav-users">
			<li class="nav-item"><a href="LogoutServlet">Salir</a></li>
			<li class="nav-item active disable"><a class="nav-link"
				href="LoginProfesor">PROFESOR</a></li>
			<c:if
				test="${ profesor.email.equals(profesor.departamento.responsable.email)}">
				<li class="nav-item"><a class="nav-link"
					href="LoginResponsableServlet">RESPONSABLE</a></li>
			</c:if>
			<c:if test="${ fn:length(asignaturaCoordinador_list)> 0}">
				<li class="nav-item"><a class="nav-link"
					href="LoginCoordinadorServlet">COORDINADOR</a></li>
			</c:if>
		</ul>
	</div>	
	
	<img class="center" src="./imgs/etsit.png" style="">
	
	<div class="barraAcciones">
					<ul class="nav nav-pills nav-fill justify-content-center">
						<li class="nav-item"><a class="nav-link" href="LoginProfesorServlet?menu=0">Perfil</a></li>
						<li class="nav-item"><a class="nav-link" href="LoginProfesorServlet?menu=1">Asignaturas
								impartidas</a></li>
					</ul>
				</div>
	

				
				
			
				<div class="container2">
					<c:choose>
						<c:when test="${menuProfesor == 0}">
							<%@ include file="LoginProfesorPerfil.jsp"%>
						</c:when>
						<c:when test="${menuProfesor == 1}">
							<%@ include file="LoginProfesorAsignaturas.jsp"%>
						</c:when>
					</c:choose>

				</div>
			
		
	

</body>
</html>