<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Dirección</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Nueva Dirección</h1>
		<form:form action="/direcciones/crear" method="post" modelAttribute="direccion">
			<div>
				<form:label path="calle">Calle</form:label>
				<form:input path="calle" class="form-control"/>
				<form:errors path="calle" class="text-danger"/>
			</div>
			<div>
				<form:label path="numero">Número</form:label>
				<form:input path="numero" class="form-control"/>
				<form:errors path="numero" class="text-danger"/>
			</div>
			<div>
				<form:label path="ciudad">Ciudad</form:label>
				<form:input path="ciudad" class="form-control"/>
				<form:errors path="ciudad" class="text-danger"/>
			</div>
			<div>
				<form:label path="cp">CP</form:label>
				<form:input path="cp" class="form-control"/>
				<form:errors path="cp" class="text-danger"/>
			</div>
			<div>
				<form:label path="pais">País</form:label>
				<form:input path="pais" class="form-control"/>
				<form:errors path="pais" class="text-danger"/>
			</div>
			<div>
				<form:label path="usuario">Usuario</form:label>
				<form:select path="usuario" class="form-select">
					<c:forEach items="${usuarios}" var="us">
						<form:option value="${us.id}">${us.firstName} ${us.lastName}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="usuario" class="text-danger" />
			</div>
			<input type="submit" value="Guardar" class="btn btn-success mt-3" >
		</form:form>
	</div>
</body>
</html>