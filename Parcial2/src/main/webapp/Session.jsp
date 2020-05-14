<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@page contentType="text/html"%>
	<%@page pageEncoding="UTF-8"%>
	<meta charset="utf-8">
<title>Insert title here</title>


</head>
<body>

<form action="ServeletUser" method="post">
		
		<label for="username">Usuario</label>
		<input type="text" placeholder="Introdusca usuario" name="user">
		
		<label for="password">Contrasenia</label>
		<input type="password" placeholder="Introdusca contrasenia"  name="pass">

		<input type="submit" value="Entrar">


	</form>

</body>
</html>