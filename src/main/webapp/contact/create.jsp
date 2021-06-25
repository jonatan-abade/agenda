<%@include file="../includes/header.html"%>

<div class="container">
	<h1>Criar novo contato</h1>
	<form name="formContato" action="../store" class="shadow-sm p-10">
		<div>
			<input type="text" name="name" placeholder="Nome" />
		</div>
		<div>
			<input type="text" name="phone" placeholder="Telefone">
		</div>
		<div>
			<input type="email" name="email" placeholder="E-mail">
		</div>
		<div>
			<input type="submit" class="btn btn-success" value="Salvar">
		</div>
	</form>

</div>

<%@include file="../includes/footer.html"%>