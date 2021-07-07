<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../includes/header.jsp"%>

<div class="container">
	<div class="row justify-content-md-center">
		<form name="formContato" action="/Agenda/updateTask" class="col-6 shadow p-3 rounded mt-3">
			<h1>Editar tarefa</h1>
			<input readonly type="hidden" name="id" value="<%out.print(request.getAttribute("id"));%>" class="form-control" />
			<div class="mb-3">
				<label for="title" class="form-label">Título</label>
				<input type="text" name="title" placeholder="Título"  value="<%out.print(request.getAttribute("title"));%>" class="form-control" />
			</div>
			<div class="mb-3">
				<div class="form-floating">
				  <textarea class="form-control" id="description" name="description" style="height: 100px"><%out.print(request.getAttribute("description"));%>
				  </textarea>
				  <label for="description">Descrição da tarefa</label>
				</div>
			</div>
			<div class="mb-3">
				<select class="form-select" aria-label="Default select example" name="status">
				  <option selected value="<%out.print(request.getAttribute("status"));%>"><%out.print(request.getAttribute("status"));%></option>
				  <option value="aguardando">Aguardando</option>
				  <option value="processando">Em processo</option>
				  <option value="concluida">Concluída</option>
				</select>
			</div>
			<div>
				<input type="submit" class="btn btn-success" value="Salvar">
			</div>
		</form>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>