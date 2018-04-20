<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<body onload="myFunction()">

	<script>
		function myFunction() {
			if (document.getElementById("def").selected) {
				document.getElementById("nombre").style.display = "none";
				document.getElementById("acronimo").style.display = "none";

			} else {
				document.getElementById("nombre").style.display = "inline";
				document.getElementById("acronimo").style.display = "inline";

			}
		}
	</script>

	<form action="FormRespEditarPlanServlet">



		<select id="selector" onchange="myFunction()" name="codigo"
			class="form-control">
			<option id="def">Elija Plan</option>
			<c:forEach items="${plan_list}" var="planEstudioi">
				<option value="${ planEstudioi.codigo}">${planEstudioi.codigo}</option>
			</c:forEach>
		</select> <input id="nombre" type="text" name="nombre" class="form-control"
			placeholder="Nombre completo"> <input id="acronimo"
			type="text" name="acronimo" class="form-control"
			placeholder="Acrónimos">




		<button type="submit">EditarPlan</button>

	</form>
</body>
</html>
