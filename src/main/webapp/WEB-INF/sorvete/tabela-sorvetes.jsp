<%@include file="/WEB-INF/imports.jsp"%>

<fmt:setLocale value="pt_BR"/>
<table class="table table-hover table-striped table-bordered">
	<thead>
		<tr>
			<td style="width: 10%">#</td>
			<td style="width: 30%">Nome</td>
			<td style="width: 10%">Preço</td>
			<td style="width: 15%">Categoria</td>
			<td style="width: 25%">Ingredientes</td>
			<td style="width: 5%">Editar</td>
			<td style="width: 5%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="sorvete" items="${sorvetes}">
			<tr data-id="${sorvete.id}">
				<td>${sorvete.id }</td>
				<td>${sorvete.nome }</td>
				<td>
					<fmt:formatNumber value="${sorvete.preco}" type="currency" />
				</td>
				<td>${sorvete.categoria }</td>
				<td>
					<c:forEach items="${sorvete.ingredientes }" var="ingrediente">
						${ingrediente.nome}<br>
					</c:forEach>
				</td>
				<td><button class="btn btn-warning btn-editar">Editar</button></td>
				<td><button class="btn btn-danger btn-deletar">Deletar</button></td>	
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">Ingredientes cadastrados: <span id="quantidade-sorvetes">${sorvetes.size()}</span></td>
		</tr>
		<tr>
			<td colspan="7">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-sorvete">Cadastrar Sorvete</button>
			</td>
		</tr>
	</tfoot>
</table>