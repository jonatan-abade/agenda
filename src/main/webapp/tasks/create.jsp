<%@include file="../includes/header.jsp"%>

<div class="container">
	<div class="row justify-content-md-center">
		<form action="/Agenda/addTask" method="get" class="col-6 shadow p-3 rounded mt-3">
			<h1>Criar nova Tarefa</h1>
			<div class="mb-3">
				<label for="nome" class="form-label">Título</label>
				<input type="text" name="title" placeholder="Título" class="form-control" />
			</div>
			<div class="mb-3">
				<div class="form-floating">
				  <textarea class="form-control" id="description" name="description" style="height: 100px"></textarea>
				  <label for="description">Descrição da tarefa</label>
				</div>
			</div>
			<div class="mb-3">
				<select class="form-select" aria-label="Default select example" name="status">
				  <option selected>Status</option>
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