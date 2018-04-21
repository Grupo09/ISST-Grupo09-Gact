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

<div class="page-header">
	<h3>Editar plan de estudios</h3>
</div>


<script>
function myFunction() {
	if(document.getElementById("def").selected){
		document.getElementById("nombre").style.display = "none";
		document.getElementById("acronimo").style.display = "none";

	}else{
		document.getElementById("nombre").style.display = "inline";
		document.getElementById("acronimo").style.display = "inline";

	}
}
</script>

<form action="FormRespEditarPlanServlet">

		
	<div class="col-sm-4"> 
		<select  style=" margin-bottom: 20px;" id = "selector" onchange="myFunction()" name="codigo" class="form-control">
			<option id="def"  >Elija Plan</option>
			<c:forEach items="${plan_list}" var="planEstudioi">
				<option value="${ planEstudioi.codigo}">${planEstudioi.codigo}</option>
			</c:forEach>
		</select>
		</div>
		
		 
	      <div class="col-sm-4">   
	
		<input  class="form-control" id = "nombre" type="text" name="nombre" class="form-control" placeholder="Nombre completo"> 
		</div>
		
	    <div class="col-sm-4">
		<input  class="form-control" id = "acronimo" type="text" name="acronimo" class="form-control" placeholder="Acrónimos"> 
		</div>
	
      <div class="col-sm-12">   
	<button  class="btn btn-primary" type="submit" style="margin-top: 40px; margin-bottom: 10px;">EditarPlan</button>
	
	<button class="btn btn-danger"  type="submit" formaction="FormRespEliminarPlanServlet" style="margin-top: 40px; margin-bottom: 10px;">Eliminar plan</button>	
	
	</div>
	

</form>
</body>
</html>
