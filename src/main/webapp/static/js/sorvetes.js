$(document).ready(function(){
	
	aplicarListeners();
	aplicarListenersBtnSalvar();
	
});

var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#preco').val('');
	$('#categoria').val('');
	$('#ingredientes option').attr('selected', false);	
};

var aplicarListenersBtnSalvar = function(){
	
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
};

var aplicarListeners = function(){
	
	$('#modal-sorvete').on('hide.bs.modal', limparModal);
	
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
	
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'sorvetes/'+id;
		
		$.get(url)
			.done(function(sorvete){
				$('#id').val(sorvete.id);
				$('#nome').val(sorvete.nome);
				$('#preco').val(sorvete.preco);
				$('#categoria').val(sorvete.categoria);
				
				sorvete.ingredientes.forEach(function(ingrediente){
					var idSorvete = ingrediente.id;
					$('#ingredientes option[value='+idSorvete+']').attr('selected',true);
				});
					
				
				$('#modal-sorvete').modal('show');
			});
	});
	
	
	
	
};