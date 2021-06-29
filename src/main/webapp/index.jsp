<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="includes/header.html"%>


<c:set var="data"></c:set>
<div class="row justify-content-md-center mt-5 posiion-relative">
	<form action="LoginServlet" method="post"
		class="grid col-6 position-absolute top-50 start-50 translate-middle">
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Email
				address</label> <input type="email" class="form-control" id="email"
				name="email" value="admin@admin">

		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label>
			<input type="password" class="form-control" id="password"
				name="password" value="admin">
		</div>
		<button type="submit" class="btn btn-primary">Entrar</button>
	</form>
</div>

<%@include file="includes/footer.html"%>