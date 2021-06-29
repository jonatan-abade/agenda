<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="beans.ContactBean"%>
<%@ page import="java.util.ArrayList"%>

<%@include file="../includes/header.jsp"%>
	<div class="container">
		<h1>Contatos</h1>
		<a href="users/create.jsp" class="btn btn-primary">Novo usuário</a>

		<table class="table table-hover">
			<thead>
				<td>Id</td>
				<td>Nome</td>
				<td>E-mail</td>
				<td>#</td>
			</thead>
			<tbody>
				<tr>
					<td colspan="5">Aqui ficarão listados os usuários</td>
				</tr>

			</tbody>
		</table>
	</div>

<%@include file="../includes/footer.jsp"%>