
<h3>${asignatura.nombre}</h3>

<table class="table table-striped" style="text-align: center">
	<tr>
		<td><b>Profesor</b></td>
		<td><b>Horas Laboratorio</b></td>
		<td><b>Horas Practica</b></td>
		<td><b>Horas Teoria</b></td>
	</tr>
	<c:forEach items="${asignatura.asignaciones}" var="asignacion">
		<form action="FormCoordHorasServlet">
			<tr>
				<input type="hidden" name="codigo" value="${asignatura.codigo}">
				<input type="hidden" name="asignacion_id" value="${asignacion.id}">
				<td>${asignacion.profesor.email}</td>
				<td><input type="number" name="horasLaboratorio"
					value="${asignacion.horasLaboratorio}"
					placeholder="${asignacion.horasLaboratorio}"></td>
				<td><input type="number" name="horasPractica"
					value="${asignacion.horasPractica}"
					placeholder="${asignacion.horasPractica}"></td>
				<td><input type="number" name="horasTeoria"
					value="${asignacion.horasTeoria}"
					placeholder="${asignacion.horasTeoria}"></td>
				<td><button type="submit">Guardar</button></td>
			</tr>
		</form>
	</c:forEach>
	<tr>
		<td><b>Asignadas/Totales</b></td>
		<td><b>${horasLaboratorio}/${asignatura.horasLaboratorio}</b></td>
		<td><b>${horasPractica}/${asignatura.horasPractica}</b></td>
		<td><b>${horasTeoria}/${asignatura.horasTeoria}</b></td>
	</tr>
</table>

