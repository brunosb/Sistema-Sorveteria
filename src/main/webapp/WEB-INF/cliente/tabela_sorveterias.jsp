<%@include file="/WEB-INF/imports.jsp"%>

<fmt:setLocale value="pt_BR"/>
<table class="table table-hover table-striped table-bordered">
	<thead>
		<tr>
			<td style="width: 30%">Nome</td>			
			<td style="width: 40%">Endereço</td>			
			<td style="width: 20%">Atendendo desde</td>			
			<td style="width: 10%">Entre em contato</td>			
		</tr>
	</thead>
	<tbody>
		<c:forEach var="sorveteria" items="${sorveterias}">
			<tr data-id="${sorveteria.id}">
				<td>${sorveteria.nome }</td>	
				<td>${sorveteria.endereco }</td>	
				<td><fmt:formatDate value="${sorveteria.dataCadastro.time }" pattern="dd/MM/yyyy"/></td>	
				<td><a href="#">Contato</a></td>	
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">Sorveterias Encontradas: <span id="quantidade-sorveteria">${sorveterias.size()}</span></td>
		</tr>
	</tfoot>
</table>