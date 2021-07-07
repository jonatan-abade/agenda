<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
String nameUser = (String)session.getAttribute("nameUser"); 
if(nameUser == null){
	response.sendRedirect("index.jsp");
}
%>

<!DOCTYPE html>
<html lang="pt=br">
<head>
<meta charset="utf-8">
<title>Agenda de contatos</title>
<link rel="icon" href="images/favicon.png">
<link rel="stylesheet" href="style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand" href="/home">Agenda</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarText"
				aria-controls="navbarText" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="/Agenda/contacts">Contatos</a></li>
					<li class="nav-item"><a class="nav-link" href="/Agenda/tasks">A fazer</a></li>
					<li class="nav-item"><a class="nav-link" href="/Agenda/users">Usuários</a></li>
				</ul>
				<span class="navbar-text">Seja bem-vindo <b>${nameUser}</b> <a href="/Agenda/logout">Sair</a></span>
			</div>
		</div>
	</nav>