<%@include file="/WEB-INF/imports.jsp" %>

<style>
	#btn-sair{
		margin-top: 7px;
	}
</style>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><spring:message code="views.menu.sorveteria" /></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="sorveterias">Sorveterias</a></li>
        
        <li>
        	<a href="?lang=pt_BR">
        		<img alt="PortuguÍs" src="${path }/static/img/br.png" height="25px">
        	</a>
       	</li>
       	<li>
        	<a href="?lang=en_US">
        		<img alt="English" src="${path }/static/img/usa.png" height="25px">
        	</a>
       	</li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li>
        	<a href="#" class="btn btn-default">Me Cadastrar</a>
       	</li>
         <li>
        	<a href="#" class="btn btn-primary">Entrar</a>
       	</li>
        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>