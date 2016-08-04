<%@include file="/WEB-INF/imports.jsp"%>

<html>
	<head>
		<title>Sorveteria Login</title>
		
		<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />
		
		<style type="text/css">
			@IMPORT url("${path}/static/bootstrap/css/bootstrap.min.css");
			@IMPORT url("${path}/static/bootstrap/css/bootstrap-theme.min.css");
			
			#login{
				width: 400px;
				margin-left: auto;
				margin-right: auto;
				margin-top: 100px;
			}
			#btn-login{
				width: 100%;
			}
			
		</style>
	</head>
	
	<body>
		<div id="login" class="panel panel-primary">
		
			<c:if test='${not empty param["semacesso"]}'>
				<div class="alert alert-warning">
					Usuário e/ou senha inválidos!!!
				</div>
			</c:if>
			
			<c:if test='${not empty param["saiu"]}'>
				<div class="alert alert-info">
					Você está fora do sistema!
				</div>
			</c:if>
		
			<form action="${path}/autenticar" method="post">
				<div class="panel-heading">
					Sorveteria  -  Login
				</div>
				
				<div class="panel-body">
					<label for="usuario"></label>
					<input id="usuario" name="usuario" class="form-control" required>
					
					<label for="senha"></label>
					<input type="password" id="senha" name="senha" class="form-control" required>
				</div>
				<div class="panel-footer">
					<button id="btn-login" class="btn btn-primary">Entrar</button>
				</div>
				
				<input type="hidden" id="_csrf" name="_csrf" value="${_csrf.token}">
			</form>
		</div>
	</body>
</html>