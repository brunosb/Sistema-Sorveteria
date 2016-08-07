$(document).ready(function(){
	$('#btn-buscar').on('click',buscar);
});

var buscar = function(){
	var nomeSorvete = $('#sorvete_pesquisa').val();
	var url = 'sorvete/'+nomeSorvete;
	
	$.get(url)
	.done(function(view){
		$('secao-sorveterias').html(view);
	});
};