<form action="FormNuevoProfesorServlet">
	
	<div class="col-sm-3">
		<input type="text" name="email" class="form-control"
			placeholder="Email">
	</div>
	<div class="col-sm-3">
		<input type="text" name="nombre" class="form-control"
			placeholder="Nombre completo">
	</div>
	<div class="col-sm-3">
		<input type="password" name="password" class="form-control"
			placeholder="Contraseña">
	</div>
	<div class="col-sm-3">
		<select name="departamento" class="form-control">
			<option value="" disabled selected>Departamento</option>
			<c:forEach items="${departamento_list}" var="departamentoi">
				<option value="${ departamentoi.codigo}">${departamentoi.nombre}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-sm-12">
		<button type="submit" class="btn btn-primary" style="margin-top: 5px; margin-bottom: 10px;">Registrar
			Profesor</button>
	</div>

</form>
