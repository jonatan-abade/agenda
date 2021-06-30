<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="beans.UserBean"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<UserBean> list = (ArrayList<UserBean>) request.getAttribute("users");
//ArrayList<UserBean> list = new ArrayList<>();
%>
<%@include file="../includes/header.jsp"%>
	<div class="container">
		<h1>Usuários</h1>
		<a href="users/create.jsp" class="btn btn-primary">Novo usuário</a>

		<table class="table table-hover">
			<thead>
				<td>Id</td>
				<td>Nome</td>
				<td>E-mail</td>
				<td>#</td>
			</thead>
			<tbody>
				<% if(list.size() == 0){ %>
				<tr>
					<td colspan="5">Nenhum usuário cadastrado</td>
				</tr>
				<% }else{
					for (int i = 0; i < list.size(); i++) {%>
					<tr>
						<td><%=Integer.toString(list.get(i).getId())%></td>
						<td><%=list.get(i).getName()%></td>
						<td><%=list.get(i).getEmail()%></td>
						<td>
							<a href="edit?id=<%= list.get(i).getId() %>" class="btn btn-warning">Editar</a>
							<a href="delete?id=<%= list.get(i).getId() %>" class="btn btn-danger">Excluir</a>
						</td>
					</tr>
				<% }
				} %>

			</tbody>
		</table>
	</div>

<%@include file="../includes/footer.jsp"%>