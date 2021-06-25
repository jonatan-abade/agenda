<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> list = (ArrayList<JavaBeans>) request.getAttribute("contacts");
%>
<%@include file="../includes/header.html"%>
	<div class="container">
		<h1>Agenda de contatos</h1>
		<a href="contact/create.jsp" class="btn btn-primary">Novo contato</a>

		<table class="table table-hover">
			<thead>
				<td>Id</td>
				<td>Nome</td>
				<td>Telefone</td>
				<td>E-mail</td>
				<td>#</td>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < list.size(); i++) {
				%>
				<tr>
					<td><%=Integer.toString(list.get(i).getId())%></td>
					<td><%=list.get(i).getName()%></td>
					<td><%=list.get(i).getPhone()%></td>
					<td><%=list.get(i).getEmail()%></td>
					<td>
						<a href="edit?id=<%= list.get(i).getId() %>" class="btn btn-warning">Editar</a>
						<a href="delete?id=<%= list.get(i).getId() %>" class="btn btn-danger">Excluir</a>
					</td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>

<%@include file="../includes/footer.html"%>