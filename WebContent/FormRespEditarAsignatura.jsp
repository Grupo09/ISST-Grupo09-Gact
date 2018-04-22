<form action="FormRespEditarAsignaturaServlet">
	<input type="hidden" name="departamento"
		value="${ profesor.departamento.codigo}"> <select
		name="planEstudios" class="form-control">
		<option value="" disabled selected>Elija Plan</option>
		<c:forEach items="${planEstudios_list}" var="planEstudioi">
			<option value="${ planEstudioi.codigo}">${planEstudioi.acronimo}</option>
		</c:forEach>

	</select>

	<div class="clearfix"></div>

	<button type="submit">Elegir Plan</button>

</form>