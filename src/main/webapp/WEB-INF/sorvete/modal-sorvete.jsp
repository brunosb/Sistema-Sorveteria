<%@include file="/WEB-INF/imports.jsp"%>

<div class="modal fade" id="modal-sorvete" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form method="post" id="form-sorvete">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informações do Sorvete</h4>
				</div>
				<div class="modal-body">
				
					<input type="hidden" id="id" name="id"/>
					<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}"> 
				
					<label for="nome">Nome:</label>
					<input id="nome" name="nome" class="form-control">
					
					<label for="nome">Preço:</label>
					<input id="preco" name="preco" class="form-control">
					
					<label for="categoria">Categoria:</label>
					<select id="categoria" name="categoria" class="form-control">
						<c:forEach items="${categorias}" var="categoria">
							<option value="${categoria}">${categoria}</option>
						</c:forEach>
					</select>
					
					<label for="Ingredientes">Ingredientes:</label>
					<select id="Ingredientes" name="Ingredientes" class="form-control" multiple="multiple">
						<c:forEach items="${ingredientes}" var="ingrediente">
							<option value="${ingrediente.id}">${ingrediente.nome}</option>
						</c:forEach>
					</select>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button type="button" class="btn btn-primary" id="btn-salvar">Salvar Informações</button>
				</div>
			</form>
		</div>
	</div>
</div>