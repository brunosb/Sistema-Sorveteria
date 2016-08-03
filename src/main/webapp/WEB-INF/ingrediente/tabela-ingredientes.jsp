<%@include file="/WEB-INF/imports.jsp"%>

<table class="table table-hover table-striped table-bordered">
	<thead>
		<tr>
			<td style="width: 10%">#</td>
			<td style="width: 50%">Nome</td>
			<td style="width: 20%">Categoria</td>
			<td style="width: 10%">Editar</td>
			<td style="width: 10%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="ingredientes" items="${ingredientes }">
			<tr data-id="${ingredientes.id}">
				<td>${ingredientes.id }</td>
				<td>${ingredientes.nome }</td>
				<td>${ingredientes.categoria }</td>
				<td><button class="btn btn-warning btn-editar">Editar</button></td>
				<td><button class="btn btn-danger btn-deletar">Deletar</button></td>	
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">Ingredientes cadastrados: <span id="quantidade-ingredientes">${ingredientes.size()}</span></td>
		</tr>
		<tr>
			<td colspan="5">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-ingrediente">Cadastrar Ingrediente</button>
			</td>
		</tr>
	</tfoot>
</table>