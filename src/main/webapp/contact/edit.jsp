<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../includes/header.jsp"%>

<div class="container">
	<div class="row justify-content-md-center">
		<form name="formContato" action="update" class="col-6 shadow p-3 rounded mt-3">
			<h1>Editar contato</h1>
			<input readonly type="hidden" name="id" value="<%out.print(request.getAttribute("id"));%>" class="form-control" />
			<div class="mb-3">
				<label for="nome" class="form-label">Nome</label>	
				<input type="text" name="name" value="<%out.print(request.getAttribute("name"));%>" class="form-control" />
			</div>
			<div class="mb-3">
				<label for="nome" class="form-label">Telefone</label>	
				<input type="text" name="phone" value="<%out.print(request.getAttribute("phone"));%>" class="form-control">
			</div>
			<label for="nome" class="form-label">E-mail</label>	
			<div class="mb-3">
				<input type="email" name="email" value="<%out.print(request.getAttribute("email"));%>" class="form-control">
			</div>
			<div>
				<input type="submit" class="btn btn-success" value="Salvar">
			</div>
		</form>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>