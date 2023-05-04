<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asignar Hobby</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>${usuario.firstName} ${usuario.lastName}</h1>
		<h2>Hobbies</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Actividad</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${hobbies}" var="hobby">
					<tr>
						<td>${hobby.actividad}</td>
						<td>
							<form action="/asignarHobby" method="post">
								<input type="hidden" name="usuario_id" value="${usuario.id}">
								<input type="hidden" name="hobby_id" value="${hobby.id}">
								<input type="submit" value="Asignar Hobby" class="btn btn-primary">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>