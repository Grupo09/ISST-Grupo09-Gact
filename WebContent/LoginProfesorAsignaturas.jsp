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
</head>
<body>


	<table class="table table-striped" style="text-align: center">
		<tr>
			<td><b>Asignatura</b></td>
			<td><b>Horas Laboratorio</b></td>
			<td><b>Horas Practica</b></td>
			<td><b>Horas Teoria</b></td>
			<td><b>Consultas Coordinador</b></td>
		</tr>
		<c:forEach items="${asignatura_list}" var="asignaturai">
			<tr>
				<td>${asignaturai.acronimo}</td>
				<c:forEach items="${asignaturai.asignaciones}" var="asignacion">
					<c:if test="${asignacion.profesor.email == profesor.email}">
						<td>${asignacion.horasLaboratorio}</td>
						<td>${asignacion.horasPractica}</td>
						<td>${asignacion.horasTeoria}</td>
						<td><form action="EmailSendingServlet" method="post">
								<input type="hidden" name="recipient"
									value="${asignaturai.coordinador.email}"> <input
									type="hidden" name="user" value="${profesor.email}"> <input
									type="hidden" name="subject"
									value="Notificacion de ${asignaturai.nombre }}">
								<textarea rows="5" cols="20" name="content"></textarea>
								<button type="submit">Enviar</button>
							</form></td>
					</c:if>
				</c:forEach>

			</tr>
		</c:forEach>
	</table>

</body>
</html>