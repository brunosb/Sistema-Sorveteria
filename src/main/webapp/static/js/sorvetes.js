$(document).ready(function(){
	
	aplicarListeners();
	
});

var aplicarListeners = function(){
	
	$('#btn-salvar').on('click',function(){
		var url = 'sorvetes';
		var dadosSorvete = $('#form-sorvete').serialize();
		
		$.post(url,dadosSorvete)
			.done(function(pagina){
				$('#div-table-sorvetes').html(pagina);
				aplicarListeners();
			})
			.fail(function(){
				alert('Erro ao Salvar!')
			})
			.always(function(){
				$('#modal-sorvete').modal('hide');
			});
	});
	
	$('.btn-deletar').on('click',function(){
		
		var id = $(this).parents('tr').data('id');
		
		$.ajax({
			url: "sorvetes/"+id,
			type:'DELETE',
			success: function(){
				$('tr[data-id="'+id+'"]').remove();
				var sorvetes = parseInt($('#quantidade-sorvetes').text());
				$('#quantidade-sorvetes').text(sorvetes-1);
			}
		});
	});
	
	
	
	
	
	
	
};