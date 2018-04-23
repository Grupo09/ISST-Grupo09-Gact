

<form action="FormRespEditarAsignatura2Servlet">
              
	<input type="hidden" name="departamento"
		value="${profesor.departamento.codigo}"> 
		
		<input type = "text" name="asignatura"
		value="${ asignatura.codigo}">

		
		<input type="hidden" name="planEstudios" class="form-control" placeholder="Código" value="${planEstudios.codigo}" > 
		
		<!-- <input type="hidden" name="codigo" class="form-control" placeholder="Código"  >  -->
		<input type="text" name="nombre" class="form-control" placeholder="Nombre completo" > 
		<input type="text" name="acronimo" class="form-control" placeholder="Acrónimos"> 
		<input type="text" name="creditos" class="form-control" placeholder="Créditos"> 
		<input type="number" name="curso" class="form-control" placeholder="Curso" >
		<input type="number" name="semestre" class="form-control"placeholder="Semestre"> 
		<input type="number" name="grupos" class="form-control" placeholder="Número de grupos" >
	 	<input type="number" name="horasTeoria" class="form-control" placeholder="Horas Teoría" > 
	 	<input type="number" name="horasPractica" class="form-control" placeholder="Horas Práctica" >
		<input type="number" name="horasLaboratorio" class="form-control" placeholder="Horas Laboratorio" > 
		
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
			<option value=""  selected disabled>Elija Coordinador</option>
			<!-- con javascript se rellenara y tendras:
			<option value="${ profesori.email}">${profesori.nombre}</option>-->
			
		</select> 
	
 	<div class="col-sm-12">   
	<button  class="btn btn-primary" type="submit" style="margin-top: 40px; margin-bottom: 10px;">Editar Asignatura</button>
	
	<button class="btn btn-danger"  type="submit" formaction="FormRespEliminarAsignaturaServlet" style="margin-top: 40px; margin-bottom: 10px;">Eliminar Asignatura</button>	
	
	</div>
	
</form>