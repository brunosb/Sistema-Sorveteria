<%@include file="/WEB-INF/imports.jsp" %>
<html>
	<head>
		<title>Qual seu Pedido</title>
		
		<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />
		
		<style type="text/css">
			@IMPORT url("${path}/static/bootstrap/css/bootstrap.min.css");
			@IMPORT url("${path}/static/bootstrap/css/bootstrap-theme.min.css");
			
			#btn-buscar{
				margin-top: 25px;
			}
		</style>
	</head>
	
	<body>
		<div class="container">
			<jsp:include page="../menu-cliente.jsp" />
			
			<section>
				<div id="consulta-sorveterias" class="well">
					<div class="row">
						<div class="col-sm-4">
							<label for="sorvete_pesquisa">Que Sorvete voçê quer hoje?</label>
							<select id="sorvete_pesquisa" class="form-control">
								<c:forEach items="${nomesSorvetes}" var="sorvete">
									<option value="${sorvete}">${sorvete}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-4">
							<button id="btn-buscar" class="btn btn-primary">Buscar Sorvetes</button>
						</div>
					</div>
				</div>
				<div id="secao-sorveterias">
				
				</div>
			</section>
		</div>
		
		<script type="text/javascript" src="${path}/static/js/jquery-3.1.0.min.js"></script>
		<script type="text/javascript" src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${path}/static/js/sorveterias.js"></script>
		
	</body>
</html>