<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServeletUser" method="post">
		<!-- Usuario-->
		<label for="username">Usuario</label>
		<input type="text" placeholder="Introdusca usuario" name="user">
		<!-- Usuario-->
		<label for="password">Contrase�a</label>
		<input type="password" placeholder="Introdusca contrase�a"  name="pass">

		<input type="submit" value="Entrar">


	</form>
</body>
</html>