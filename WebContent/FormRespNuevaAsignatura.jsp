<form action="FormRespNuevaAsignaturaServlet">
	<input type="hidden" name="departamento"
		value="${ profesor.departamento.codigo}"> 
		<select name="planEstudios" class="form-control">
			<option value="" disabled selected>Elija Plan</option>
			<c:forEach items="${planEstudios_list}" var="planEstudioi">
				<option value="${ planEstudioi.codigo}">${planEstudioi.acronimo}</option>
			</c:forEach>
		</select>
		<input type="text" name="codigo" class="form-control" placeholder="Código" required> 
		<input type="text" name="nombre" class="form-control" placeholder="Nombre completo" required> 
		<input type="text" name="acronimo" class="form-control" placeholder="Acrónimos" required> 
		<input type="text" name="creditos" class="form-control" placeholder="Créditos" required> 
		<input type="number" name="curso" class="form-control" placeholder="Curso" required>
		<input type="number" name="semestre" class="form-control"placeholder="Semestre" required> 
		<input type="number" name="grupos" class="form-control" placeholder="Número de grupos" required>
	 	<input type="number" name="horasTeoria" class="form-control" placeholder="Horas Teoría" required> 
	 	<input type="number" name="horasPractica" class="form-control" placeholder="Horas Práctica" required>
		<input type="number" name="horasLaboratorio" class="form-control" placeholder="Horas Laboratorio" required> 
		<select multiple name="b" id='lstBox1' class="form-control">
			<c:forEach items="${profesor.departamento.profesores}" var="profesori">
				<option value="${ profesori.email}">${profesori.nombre}</option>
			</c:forEach>
		</select> 
		<input type='button' id='btnLeft' value='Quitar Profesor' class="btn btn-default" /><br /> 
		<input type='button' id='btnRight'value='Añadir Profesor' class="btn btn-default" /> 
		
		<select multiple  id='lstBox2' class="form-control">
		</select>
		<select style="visibility: hidden; height: 0 !important;"  multiple name="ProfesoresSeleccionados"  id='lstBox3' class="form-control" >
		</select>
	
		<select name="coordinador" id='coordinador' class="form-control">
			<option value=""  selected disabled>Elija Coordinador</option>
			<!-- con javascript se rellenara y tendras:
			<option value="${ profesori.email}">${profesori.nombre}</option>-->
			
		</select> 
	

	<div class="clearfix"></div>

	<button type="submit">Crear asignatura</button>

</form>
