

<form action="FormRespEditarAsignatura2Servlet">
              
	<input type="hidden" name="departamento"
		value="${profesor.departamento.codigo}"> 
		
		<input type = "hidden" name="asignatura"
		value="${ asignatura }">

		
		<input type="hidden" name="planEstudios" class="form-control" placeholder="Código" value="${planEstudios }" > 
		
	    <select name="codigo" class="form-control">
		<option value=" " disabled selected>Elija Asignatura</option>

		<c:forEach items="${asignaturas_list}" var="asignaturai">
			<option value="${ asignaturai.codigo}">${ asignaturai.codigo}
			</option>
		</c:forEach>
		</select>
		
		<input type="text" name="codigo" class="form-control" placeholder="Código" value="${asignatura.codigo }" > 
		<input type="text" name="nombre" class="form-control" placeholder="Nombre completo" value="${asignatura.nombre }" > 
		<input type="text" name="acronimo" class="form-control" placeholder="Acrónimos" value="${asignatura.acronimo }"> 
		<input type="text" name="creditos" class="form-control" placeholder="Créditos" value="${asignatura.creditos }"> 
		<input type="number" name="curso" class="form-control" placeholder="Curso" value="${asignatura.curso }">
		<input type="number" name="semestre" class="form-control"placeholder="Semestre" value="${asignatura.semestre }"> 
		<input type="number" name="grupos" class="form-control" placeholder="Número de grupos" value="${asignatura.grupos}">
	 	<input type="number" name="horasTeoria" class="form-control" placeholder="Horas Teoría" value="${asignatura.horasTeoria }"> 
	 	<input type="number" name="horasPractica" class="form-control" placeholder="Horas Práctica" value="${asignatura.horasPractica }">
		<input type="number" name="horasLaboratorio" class="form-control" placeholder="Horas Laboratorio" value="${asignatura.horasLaboratorio}"> 
		
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
	<button type="submit"> Editar Asignatura </button>

	
</form>