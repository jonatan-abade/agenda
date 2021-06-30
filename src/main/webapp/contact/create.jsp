<%@include file="../includes/header.jsp"%>

<div class="container">
	
	<div class="row justify-content-md-center">
		<form name="formContato" action="../store" class="col-6 shadow p-3 rounded mt-3">
			<h1>Criar novo contato</h1>
			<div class="mb-3">
				<label for="nome" class="form-label">Nome</label>
				<input type="text" name="name" placeholder="Nome" class="form-control"/>
			</div>
			<div class="mb-3">
				<label for="nome" class="form-label">Nome</label>
				<input type="text" name="phone" placeholder="Telefone" class="form-control">
			</div>
			<div class="mb-3">
				<label for="nome" class="form-label">Nome</label>
				<input type="email" name="email" placeholder="E-mail" class="form-control">
			</div>
			<div>
				<input type="submit" class="btn btn-success" value="Salvar">
			</div>
		</form>
	</div>

</div>

<%@include file="../includes/footer.jsp"%>