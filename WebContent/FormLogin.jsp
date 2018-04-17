<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
	<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
  
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="./style/login.css">  
    <!-- Bootstrap, Jquery -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Aplicación Gestión Docente</title>
  </head>
  <body>
     <div class="container_login">
        <div class="card card-container">
        <div class="container_login_title">
        <p class='login_subtitle text-center'>BIENVENIDO A</p>
        <p class='login_title text-center'>GESTIÓN DOCENTE</p>
        </div>
        <hr>

            <form class="form-signin" action="LoginServlet">
                <span id="reauth-email" class="reauth-email"></span>
                <p class="input_title">Usuario</p>
                <input type="text" name="email" id="inputEmail" class="login_box" placeholder="usuario@upm.es" required autofocus>
                <p class="input_title">Contraseña</p>
                <input type="password" name="password" id="inputPassword" class="login_box" placeholder="******" required>
                <div id="remember" class="checkbox">
                </div>
                <button class="btn btn-lg btn-primary btn-login" type="submit">Login</button>
            </form><!-- /form -->
            <a href="LoginNuevoProfesorServlet">Registrar profesor</a>
        </div><!-- /card-container -->
    </div><!-- /container -->
  </body>
</html>