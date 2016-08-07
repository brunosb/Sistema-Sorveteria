$(document).ready(function(){
	
	aplicarListeners();
	aplicarListenersBtnSalvar();
	
});

var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#categoria').val('');
}

var aplicarListenersBtnSalvar = function(){
	$('#btn-salvar').on('click',function(){
		var url = 'ingredientes';
		var dadosIngrediente = $('#form-ingrediente').serialize();
		
		$.post(url,dadosIngrediente)
			.done(function(pagina){
				$('#div-table-ingredientes').html(pagina);
				aplicarListeners();
			})
			.fail(function(){
				alert('Erro ao Salvar!')
			})
			.always(function(){
				$('#modal-ingrediente').modal('hide');
			});
	});
};

var aplicarListeners = function(){
	
	$('#modal-ingrediente').on('hide.bs.modal',limparModal);
	
	
	$('.btn-deletar').on('click',function(){
		
		var id = $(this).parents('tr').data('id');
		var csrf = $("#csrf").val();
		
		$.ajax({
			url: "ingredientes/"+id,
			type:'DELETE',
			headers: {'X-CSRF-TOKEN': csrf},
			success: function(){
				$('tr[data-id="'+id+'"]').remove();
				var ingredientes = parseInt($('#quantidade-ingredientes').text());
				$('#quantidade-ingredientes').text(ingredientes-1);
			}
		});
	});
	
	$('.btn-editar').on('click',function(){
		
		var id = $(this).parents('tr').data('id');
		var url = 'ingredientes/'+id;
		
		$.get(url)
			.done(function(ingrediente){
				$('#id').val(ingrediente.id);
				$('#nome').val(ingrediente.nome);
				$('#categoria').val(ingrediente.categoria);
				$('#modal-ingrediente').modal('show');
			});
	});
	
	
	
	
	
	
	
	
}