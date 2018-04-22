<form action="FormRespEditarAsignatura1Servlet">
	<input type="hidden" name="departamento"
		value="${ profesor.departamento.codigo}">
		
		<input type="hidden" name="planEstudios"
		value="${planEstudios}"> 
		
		
		<select name="codigo" class="form-control">
		<option value=" " disabled selected>Elija Asignatura</option>

		<c:forEach items="${asignaturas_list}" var="asignaturai">
			<option value="${ asignaturai.codigo}">${ asignaturai.codigo}
			</option>
		</c:forEach>
		</select>

	<div class="clearfix"></div>

	<button type="submit">Elegir Asignatura</button>

</form>