<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../includes/header.jsp"%>

<div class="container">
	<div class="row justify-content-md-center">
		<form name="formContato" action="/Agenda/updateUser" class="col-6 shadow p-3 rounded mt-3">
			<h1>Editar user</h1>
			<input readonly type="hidden" name="id" value="<%out.print(request.getAttribute("id"));%>" class="form-control" />
			<div class="mb-3">
				<label for="nome" class="form-label">Nome</label>	
				<input type="text" name="name" value="<%out.print(request.getAttribute("name"));%>" class="form-control" />
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">E-mail</label>	
				<input type="email" name="email" value="<%out.print(request.getAttribute("email"));%>" class="form-control">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Senha</label>	
				<input type="password" name="passoword" value="<%out.print(request.getAttribute("password"));%>" class="form-control">
			</div>
			<div>
				<input type="submit" class="btn btn-success" value="Salvar">
			</div>
		</form>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>