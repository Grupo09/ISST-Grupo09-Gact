<form action="FormRespNuevaAsignaturaServlet">

	<div class="col-sm-4">
		<h5>Plan de Estudios</h5>
		<input type="hidden" name="departamento"
			value="${ profesor.departamento.codigo}"> <select
			name="planEstudios" class="form-control">
			<option value="" disabled selected>Elija Plan</option>
			<c:forEach items="${planEstudios_list}" var="planEstudioi">
				<option value="${ planEstudioi.codigo}">${planEstudioi.acronimo}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-sm-4">
		<h5>Código</h5>
		<input type="text" name="codigo" class="form-control"
			placeholder="Código" required>
	</div>
	<div class="col-sm-4">
		<h5>Nombre completo</h5>
		<input type="text" name="nombre" class="form-control"
			placeholder="Nombre completo" required>
	</div>
	<div class="col-sm-4">
		<h5>Acorónimo</h5>
		<input type="text" name="acronimo" class="form-control"
			placeholder="Acrónimos" required>
	</div>
	<div class="col-sm-4">
		<h5>Créditos</h5>
		<input type="text" name="creditos" class="form-control"
			placeholder="Créditos" required>
	</div>
	<div class="col-sm-4">
		<h5>Curso</h5>
		<input type="number" name="curso" class="form-control"
			placeholder="Curso" required>
	</div>
	<div class="col-sm-4">
		<h5>Semestre</h5>
		<input type="number" name="semestre" class="form-control"
			placeholder="Semestre" required>
	</div>
	<div class="col-sm-4">
		<h5>Número de grupos</h5>
		<input type="number" name="grupos" class="form-control"
			placeholder="Número de grupos" required>
	</div>
	<div class="col-sm-4">
		<h5>Horas de Teoría</h5>
		<input type="number" name="horasTeoria" class="form-control"
			placeholder="Horas Teoría" required>
	</div>
	<div class="col-sm-4">
		<h5>Horas de Práctica</h5>
		<input type="number" name="horasPractica" class="form-control"
			placeholder="Horas Práctica" required>
	</div>
	<div class="col-sm-4">
		<h5>Horas de Laboratorio</h5>
		<input type="number" name="horasLaboratorio" class="form-control"
			placeholder="Horas Laboratorio" required>
	</div>
	<div class="col-sm-12">
		<label>Profesores</label>
		<h5>Profesores que se pueden añadir</h5>
		<select multiple name="b" id='lstBox1' class="form-control">
			<c:forEach items="${profesor.departamento.profesores}"
				var="profesori">
				<option value="${ profesori.email}">${profesori.nombre}</option>
			</c:forEach>
		</select> <input type='button' id='btnLeft' value='Quitar Profesor'
			class="btn btn-default" /><br /> <input type='button' id='btnRight'
			value='Añadir Profesor' class="btn btn-default" />
		<h5>Profesores añadidos</h5>

		<select multiple id='lstBox2' class="form-control">
		</select> <select style="visibility: hidden; height: 0 !important;" multiple
			name="ProfesoresSeleccionados" id='lstBox3' class="form-control">
		</select>
	</div>
	<div>
		

		<select name="coordinador" id='coordinador' class="form-control">
			<option value="" selected disabled>Elija Coordinador</option>
			<!-- con javascript se rellenara y tendras:
			<option value="${ profesori.email}">${profesori.nombre}</option>-->

		</select>

	</div>
	<div class="clearfix"></div>

	<button type="submit">Crear asignatura</button>

</form>
