

<form action="FormRespEditarAsignatura2Servlet">

	<input type="hidden" name="departamento"
		value="${profesor.departamento.codigo}"> <input type="hidden"
		name="planEstudios" class="form-control"
		value="${planEstudios.codigo}"> <input type="hidden"
		name="codigo" class="form-control" value="${ asignatura.codigo}">
	<div>
		<h5>Nombre completo</h5>
		<input type="text" name="nombre" class="form-control"
			value="${ asignatura.nombre}" placeholder="Nombre completo" required>
	</div>
	<div>
		<h5>Acorónimo</h5>
		<input type="text" name="acronimo" class="form-control"
			value="${ asignatura.acronimo}" placeholder="Acrónimos" required>
	</div>
	<div>
		<h5>Créditos</h5>
		<input type="text" name="creditos" class="form-control"
			value="${ asignatura.creditos}" placeholder="Créditos" required>
	</div>
	<div>
		<h5>Curso</h5>
		<input type="number" name="curso" class="form-control"
			value="${ asignatura.curso}" placeholder="Curso" required>
	</div>
	<div>
		<h5>Semestre</h5>
		<input type="number" name="semestre" class="form-control"
			value="${ asignatura.semestre}" placeholder="Semestre" required>
	</div>
	<div>
		<h5>Número de grupos</h5>
		<input type="number" name="grupos" class="form-control"
			value="${ asignatura.grupos}" placeholder="Número de grupos" required>
	</div>
	<div>
		<h5>Horas de Teoría</h5>
		<input type="number" name="horasTeoria" class="form-control"
			value="${ asignatura.horasTeoria}" placeholder="Horas Teoría"
			required>
	</div>
	<div>
		<h5>Horas de Práctica</h5>
		<input type="number" name="horasPractica" class="form-control"
			value="${ asignatura.horasPractica}" placeholder="Horas Práctica"
			required>
	</div>
	<div>
		<h5>Horas de Laboratorio</h5>
		<input type="number" name="horasLaboratorio" class="form-control"
			value="${ asignatura.horasLaboratorio}"
			placeholder="Horas Laboratorio" required>
	</div>
	<div>
		<label>Profesores</label>
		<h5>Profesores que se pueden añadir</h5>
		<select multiple name="b" id='lstBox1' class="form-control">
			<c:forEach items="${profDisponible_lista}" var="profesori">
				<option value="${ profesori.email}">${profesori.nombre}</option>
			</c:forEach>
		</select> <input type='button' id='btnLeft' value='Quitar Profesor'
			class="btn btn-default" /><br /> <input type='button' id='btnRight'
			value='Añadir Profesor' class="btn btn-default" />
		<h5>Profesores añadidos</h5>

		<select multiple id='lstBox2' class="form-control">
			<c:forEach items="${profAsignatura_lista}" var="profesori">
				<option value="${ profesori.email}">${profesori.nombre}</option>
			</c:forEach>

		</select> <select style="visibility: hidden; height: 0 !important;" multiple
			name="ProfesoresSeleccionados" id='lstBox3' class="form-control">
			<c:forEach items="${profAsignatura_lista}" var="profesori">
				<option value="${ profesori.email}" selected>${profesori.nombre}</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<h5>Coordinador</h5>

		<select name="coordinador" id='coordinador' class="form-control">
			<c:if test="${ asignatura.coordinador == null}">
				<option value="" selected disabled>Elija Coordinador</option>
			</c:if>
			<c:if test="${ asignatura.coordinador != null}">
				<option value="${ asignatura.coordinador.email}" selected>${ asignatura.coordinador.nombre}</option>
			</c:if>
			<c:forEach items="${profAsignatura_lista}" var="profesori">
				<option value="${ profesori.email}">${profesori.nombre}</option>
			</c:forEach>

		</select>
	</div>

	<div class="col-sm-12">
		<button class="btn btn-primary" type="submit"
			style="margin-top: 40px; margin-bottom: 10px;">Editar
			Asignatura</button>

		<button class="btn btn-danger" type="submit"
			formaction="FormRespEliminarAsignaturaServlet"
			style="margin-top: 40px; margin-bottom: 10px;">Eliminar
			Asignatura</button>

	</div>

</form>