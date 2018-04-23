

<form action="FormRespEditarAsignatura2Servlet">
              
	<input type="hidden" name="departamento"
		value="${profesor.departamento.codigo}"> 	
	<input type="hidden" name="planEstudios" class="form-control"  value="${planEstudios.codigo}" > 
	<input type="hidden" name="codigo" class="form-control" value="${ asignatura.codigo}"> 
	<input type="text" name="nombre" class="form-control" value="${ asignatura.nombre}" placeholder="Nombre completo" required> 
	<input type="text" name="acronimo" class="form-control" value="${ asignatura.acronimo}" placeholder="Acrónimos" required> 
	<input type="text" name="creditos" class="form-control" value="${ asignatura.creditos}" placeholder="Créditos" required> 
	<input type="number" name="curso" class="form-control" value="${ asignatura.curso}" placeholder="Curso" required>
	<input type="number" name="semestre" class="form-control" value="${ asignatura.semestre}" placeholder="Semestre" required> 
	<input type="number" name="grupos" class="form-control" value="${ asignatura.grupos}" placeholder="Número de grupos" required>
 	<input type="number" name="horasTeoria" class="form-control" value="${ asignatura.horasTeoria}" placeholder="Horas Teoría" required> 
 	<input type="number" name="horasPractica" class="form-control" value="${ asignatura.horasPractica}" placeholder="Horas Práctica" required>
	<input type="number" name="horasLaboratorio" class="form-control" value="${ asignatura.horasLaboratorio}" placeholder="Horas Laboratorio" required> 
	
	<select multiple name="b" id='lstBox1' class="form-control">
		<c:forEach items="${profDisponible_lista}" var="profesori">
			<option value="${ profesori.email}">${profesori.nombre}</option>
		</c:forEach>
	</select> 
	<input type='button' id='btnLeft' value='Quitar Profesor' class="btn btn-default" /><br /> 
	<input type='button' id='btnRight'value='Añadir Profesor' class="btn btn-default" /> 
	
	<select multiple  id='lstBox2' class="form-control">
		<c:forEach items="${profAsignatura_lista}" var="profesori">
			<option value="${ profesori.email}">${profesori.nombre}</option>
		</c:forEach>
	</select>
	<select style="visibility: hidden; height: 0 !important;"  multiple name="ProfesoresSeleccionados"  id='lstBox3' class="form-control" >
	</select>
	
	<select name="coordinador" id='coordinador' class="form-control">
		<c:if test="${ asignatura.coordinador == null}">
				<option value=""  selected disabled>Elija Coordinador</option>
		</c:if>
		<c:if test="${ asignatura.coordinador != null}">
				<option value="${ asignatura.coordinador.email}"  selected >${ asignatura.coordinador.nombre}</option>
		</c:if>		
		<c:forEach items="${profAsignatura_lista}" var="profesori">
			<option value="${ profesori.email}">${profesori.nombre}</option>
		</c:forEach>
		
	</select> 

	<div class="col-sm-12">   
<button  class="btn btn-primary" type="submit" style="margin-top: 40px; margin-bottom: 10px;">Editar Asignatura</button>

<button class="btn btn-danger"  type="submit" formaction="FormRespEliminarAsignaturaServlet" style="margin-top: 40px; margin-bottom: 10px;">Eliminar Asignatura</button>	

</div>
	
</form>