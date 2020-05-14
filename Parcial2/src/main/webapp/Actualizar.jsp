<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%
String idBus=request.getParameter("idBus");
String Nom=request.getParameter("Nom");
String Ape=request.getParameter("Ape");


if(idBus==null){
	idBus="";
	Nom="";
	Ape="";	
}
%>
<body>
<form action="ServeletDatos">
<table align="center">
	<thead>

	</thead>
		<tbody>
			<tr>
				<td>
					<p>Id</p><input type="text" name="Id" value="<%=idBus %>">
					<p>Nombre</p><input type="text" name="Unombre" value="<%=Nom %>">
					<p>Apellido</p><input type="text" name="Uapellido" value="<%=Ape %>">
					<br>
					<br>
				</td>
			</tr>
		</tbody>
</table>

<input type="submit" class="btn btn-info" value="Actualizar" name= "btn">
</body>
</html>