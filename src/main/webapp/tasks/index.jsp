<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="beans.TaskBean"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<TaskBean> list = (ArrayList<TaskBean>) request.getAttribute("tasks");
%>
<%@include file="../includes/header.jsp"%>
	<div class="container">
		<h1>Tarefas</h1>
		<a href="tasks/create.jsp" class="btn btn-primary">Nova Tarefa</a>

		<table class="table table-hover">
			<thead>
				<td>Id</td>
				<td>Título</td>
				<td>Descrição</td>
				<td>Status</td>
				<td>#</td>
			</thead>
			<tbody>
				<% if(list.size() == 0){ %>
				<tr>
					<td colspan="5">Nenhuma tarefa cadastrado</td>
				</tr>
				<% }else{
					for (int i = 0; i < list.size(); i++) {%>
					<tr>
						<td><%=Integer.toString(list.get(i).getId())%></td>
						<td><%=list.get(i).getTitle()%></td>
						<td><%=list.get(i).getDescription()%></td>
						<td><%=list.get(i).getStatus()%></td>
						<td>
							<a href="/Agenda/editTask?id=<%= list.get(i).getId() %>" class="btn btn-warning">Editar</a>
							<a href="/Agenda/deleteTask?id=<%= list.get(i).getId() %>" class="btn btn-danger">Excluir</a>
						</td>
					</tr>
				<% }
				} %>

			</tbody>
		</table>
	</div>

<%@include file="../includes/footer.jsp"%>