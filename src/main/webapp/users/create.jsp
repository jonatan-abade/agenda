<%@include file="../includes/header.jsp"%>

<div class="container">
	<h1>Criar novo usuário</h1>
	<form name="formContato" action="addUser" class="shadow-sm p-10">
		<div>
			<input type="text" name="name" placeholder="Nome" />
		</div>
		<div>
			<input type="email" name="email" placeholder="E-mail">
		</div>
		<div>
			<input type="password" name="password">
		</div>
		<div>
			<input type="submit" class="btn btn-success" value="Salvar">
		</div>
	</form>

</div>

<%@include file="../includes/footer.jsp"%>