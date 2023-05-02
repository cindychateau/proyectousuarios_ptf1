<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenid@ ${username} a tu Dashboard! </h1>
			<a href="/new" class="btn btn-success">Agregar Usuario</a>
			<a href="/direcciones/nueva" class="btn btn-primary">Agregar Dirección</a>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>	
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Dirección</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<!-- usuarios = LIST{obj(elena), obj(juana), obj(pedro)
					usuario = obj(elena)
					usuario = obj(juana)
					usuario = obj(pedro)
				 -->
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<td>${usuario.firstName}</td>
						<td>${usuario.lastName}</td>
						<td>${usuario.email}</td>
						<td>${usuario.direccion.calle} ${usuario.direccion.numero}</td>
						<td>
							<a href="/mostrar/${usuario.id}" class="btn btn-info">Mostrar</a>
							<form action="/borrar/${usuario.id}" method="post">
								<!-- Sobre escribimos el method del formulario -->
								<input type="hidden" name="_method" value="DELETE">
								<input type="submit" value="Borrar" class="btn btn-danger" >
							</form>
							<a href="/editar/${usuario.id}" class="btn btn-warning">Editar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>