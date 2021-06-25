<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="includes/header.html"%>

<div class="container">
	<h1>Editar contato</h1>
	<form name="formContato" action="update">
		<div>
			<input readonly type="hidden" name="id"
				value="<%out.print(request.getAttribute("id"));%>" /> <input
				type="text" name="name"
				value="<%out.print(request.getAttribute("name"));%>" />
		</div>
		<div>
			<input type="text" name="phone"
				value="<%out.print(request.getAttribute("phone"));%>">
		</div>
		<div>
			<input type="email" name="email"
				value="<%out.print(request.getAttribute("email"));%>">
		</div>
		<div>
			<input type="submit" class="btn btn-success" value="Salvar">
		</div>
	</form>

</div>

<%@include file="includes/footer.html"%>