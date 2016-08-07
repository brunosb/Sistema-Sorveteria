<%@include file="/WEB-INF/imports.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listagem de Sorvetes</title>
		
		<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />
		
		<style type="text/css">
			@IMPORT url("${path}/static/bootstrap/css/bootstrap.min.css");
			@IMPORT url("${path}/static/bootstrap/css/bootstrap-theme.min.css");
		</style>
	</head>
	<body>
		<div class="container">
			<jsp:include page="../menu-sorveteria.jsp"></jsp:include>
			<c:if test="${not empty msgErro}">
				<div>
					<div class="alert alert-danger">${msgErro}</div>
				</div>
			</c:if>
			
			<c:if test="${not empty msgInfo}">
				<div>
					<div class="alert alert-info">${msgInfo}</div>
				</div>
			</c:if>
			
			<div id="div-table-sorvetes">
				<jsp:include page="tabela-sorvetes.jsp" />
			</div>
			
			<jsp:include page="modal-sorvete.jsp" />
			
		</div>
		
		<script type="text/javascript" src="${path}/static/js/jquery-3.1.0.min.js"></script>
		<script type="text/javascript" src="${path}/static/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${path}/static/js/sorvetes.js"></script>
		
	</body>
</html>







