<html>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#carga').click(function(){
			var btn = $('#carga').val();
			$.post('ServeletDatos',{

			},function(respose){

			let datos = JSON.parse(respose)
			var tabladatos = document.getElementById('tablaDatos')
			for (let item of datos) {

				tabladatos.innerHTML +=`
				<tr>

				
				<td>${item.apellido}</td>
				<td>${item.nombre}</td>
				<td>${item.id}</td>
							
				<td><a href="ServeletDatos?btn=Eliminar&Id=${item.id}" class = "btn btn-warning">Eliminar</a>
				<a href="Actualizar.jsp?idBus=${item.id}&Nom=${item.nombre}&Ape=${item.apellido}" class = "btn btn-danger">Modificar</a>
				
				</td>

				</tr>

				`

				//console.log(item.id);
			}
			});
			});
		});
		
</script>
<body>
				<a href="Login.jsp" class = "btn">INICIARSESSION</a>
 				<input type="submit" name="btn" value="CARGARDATOS" id="carga">


				<table class="table table-dark" id="tablaDatos">
					<thead>
						<th>Apellido</th>
						<th>Nombre</th>
						<th>Id</th>
						<th>Opciones</th>
					</thead>
					<tbody>
						

					</tbody>
					
				</table>

</body>
</html>
