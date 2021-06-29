<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="pt=br">
<head>
<meta charset="utf-8">
<title>Agenda</title>
<link rel="icon" href="images/favicon.png">
<link rel="stylesheet" href="style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="row justify-content-md-center mt-5 posiion-relative">
		<form action="login" method="post"
			class="grid col-6 position-absolute top-50 start-50 translate-middle">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email address</label>
				<input type="email" class="form-control" id="email" name="email" value="admin@admin">
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" class="form-control" id="password" name="password" value="admin">
			</div>
			<button type="submit" class="btn btn-primary">Entrar</button>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>