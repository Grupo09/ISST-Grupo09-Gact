<form action="FormNuevoResponsableServlet">
	<input type="hidden" name="departamento" value="${ departamentoi.codigo}">
	<select name="responsable">
			<c:if test="${ null == departamentoi.responsable}">
				<option value="" disabled selected>Elija un responsable</option>
			</c:if>
			<c:if test="${ null != departamentoi.responsable}">
				<option value="${ departamentoi.responsable.email}" selected>${departamentoi.responsable.nombre}</option>
			</c:if>
			<c:forEach items="${departamentoi.profesores}" var="profesori">
				<option value="${ profesori.email}">${profesori.nombre}</option>
			</c:forEach>
		</select>
	<button type="submit">Actualizar</button>
</form>
