<%@include file="/WEB-INF/imports.jsp"%>

<div class="modal fade" id="modal-ingrediente" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<form method="post" id="form-ingrediente">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informações do Ingrediente</h4>
				</div>
				<div class="modal-body">
				
					<input type="hidden" id="id" name="id"/>
					<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}"> 
				
					<label for="nome">Nome:</label>
					<input id="nome" name="nome" class="form-control">
					
					<label for="categoria">Categoria:</label>
					<select id="categoria" name="categoria" class="form-control">
						<c:forEach items="${categorias}" var="categoria">
							<option value="${categoria}">${categoria}</option>
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