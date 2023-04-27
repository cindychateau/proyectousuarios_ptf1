<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form:form action="/create" method="post" modelAttribute="usuario">
			<h1>Nuevo Usuario</h1>
			<div>
				<form:label path="firstName">Nombre</form:label>
				<form:input path="firstName" class="form-control"/>
				<form:errors path="firstName" class="text-danger" />
			</div>
			<div>
				<form:label path="lastName">Apellido</form:label>
				<form:input path="lastName" class="form-control"/>
				<form:errors path="lastName" class="text-danger" />
			</div>
			<div>
				<form:label path="email">E-mail</form:label>
				<form:input path="email" class="form-control"/>
				<form:errors path="email" class="text-danger" />
			</div>
			<div>
				<form:label path="password">Password</form:label>
				<form:password path="password" class="form-control"/>
				<form:errors path="password" class="text-danger" />
			</div>
			<input type="submit" value="Guardar" class="btn btn-success mt-3" >
		</form:form>
	</div>
</body>
</html>