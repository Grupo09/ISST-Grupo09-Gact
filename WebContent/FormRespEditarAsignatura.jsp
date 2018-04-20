<form action="FormRespEditarAsignaturaServlet">
	<input type="hidden" name="departamento"
		value="${ profesor.departamento.codigo}"> 
		
		<select name="planEstudios" class="form-control">
			<option value="" disabled selected>Elija Plan</option>
			<c:forEach items="${planEstudios_list}" var="planEstudioi">
				<option value="${ planEstudioi.codigo}">${planEstudioi.acronimo}</option>
			</c:forEach>
	
		</select>	
		<select name ="codigo" class="form-control" >
		<option value =" " disabled selected> Elija Asignatura </option>
		
		<c:forEach items="${asignaturas_list}" var="asignaturai">
			<option value="${ asignaturai.codigo}">${ asignaturai.codigo} </option>
		</c:forEach>
		<jsp:declaration></jsp:declaration>
		</select>

	<div class="clearfix"></div>

	<button type="submit">Editar Asignatura </button>

</form>