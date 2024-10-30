(function($) {
	"use strict";
	$(document).ready(function() {
		function toggleNavbarMethod() {
			if ($(window).width() > 992) {
				$('.navbar .dropdown').on('mouseover', function() {
					$('.dropdown-toggle', this).trigger('click');
				}).on('mouseout', function() {
					$('.dropdown-toggle', this).trigger('click').blur();
				});
			} else {
				$('.navbar .dropdown').off('mouseover').off('mouseout');
			}
		}
		toggleNavbarMethod();
		$(window).resize(toggleNavbarMethod);
	});
	$(window).scroll(function() {
		if ($(this).scrollTop() > 100) {
			$('.back-to-top').fadeIn('slow');
		} else {
			$('.back-to-top').fadeOut('slow');
		}
	});
	$('.back-to-top').click(function() {
		$('html, body').animate({ scrollTop: 0 }, 1500, 'easeInOutExpo');
		return false;
	});
	$('.date').datetimepicker({
		format: 'L'
	});
	$('.time').datetimepicker({
		format: 'LT'
	});

	$(".testimonial-carousel").owlCarousel({
		autoplay: true,
		smartSpeed: 1500,
		margin: 30,
		dots: true,
		loop: true,
		center: true,
		responsive: {
			0: {
				items: 1
			},
			576: {
				items: 1
			},
			768: {
				items: 2
			},
			992: {
				items: 3
			}
		}
	});



})(jQuery);

function mostrarNombreUsuario(nombreUsuario, usuarioId) {
	var nombreUsuarioElemento = $('#nombreUsuario');

	if (nombreUsuarioElemento.length > 0) {
		nombreUsuarioElemento.text('¡Bienvenid@, ' + nombreUsuario + ' !');
		localStorage.setItem("usuarioId", usuarioId);
		localStorage.setItem("nombreUsuario", nombreUsuario);
		obtenerReservasUsuario(localStorage.getItem('usuarioId'));
	}
	console.log('Función mostrarNombreUsuario ejecutada.');
}
mostrarNombreUsuario(localStorage.getItem('usuarioNombre'), localStorage.getItem('usuarioId'));
function obtenerReservasUsuario(usuarioId) {
	if (!usuarioId) {
		console.error('Usuario ID no válido.');
		return;
	}

	$.ajax({
		type: 'GET',
		url: 'https://carmensandovalcajusol.pythonanywhere.com/reservas/nom_cliente/' + usuarioId + '/', 
		headers: {
			'Authorization': 'Bearer ' + localStorage.getItem('token')
		},
		success: function(reservas) {
			console.log('Reservas del usuario obtenidas:', reservas);
			mostrarReservasEnInterfaz(reservas);
		},
		error: function(error) {
			console.error('Error al obtener las reservas del usuario:', error);
		}
	});
}
function obtenerNombreUsuario(usuarioId, callback) {
	usuarioId = localStorage.getItem("usuarioId")
	console.log("Obtener nombre de usuario:", usuarioId)
	if (usuarioId) {
		$.ajax({
			type: 'GET',
			url: 'https://carmensandovalcajusol.pythonanywhere.com/usuarios/' + usuarioId + '/',
			headers: {
				'Authorization': 'Bearer ' + localStorage.getItem('token')
			},
			success: function(usuario) {
				console.log("usuario", usuario)
				callback(usuario.nombre);
			},
			error: function(error) {
				console.error('Error al obtener el nombre del usuario:', error);
				callback('N/A');
			}
		});
	} else {
		callback('N/A');
	}
}

function obtenerNombreAmbiente(ambienteId, callback) {
	if (ambienteId) {
		$.ajax({
			type: 'GET',
			url: 'https://carmensandovalcajusol.pythonanywhere.com/ambientes/' + ambienteId + '/',
			headers: {
				'Authorization': 'Bearer ' + localStorage.getItem('token')
			},
			success: function(ambiente) {
				callback(ambiente.nom_ambiente);
			},
			error: function(error) {
				console.error('Error al obtener el nombre del ambiente:', error);
				callback('N/A');
			}
		});
	} else {
		callback('N/A');
	}
}

function obtenerNombreEvento(eventoId, callback) {
	$.ajax({
		type: 'GET',
		url: 'https://carmensandovalcajusol.pythonanywhere.com/eventos/' + eventoId + '/',
		headers: {
			'Authorization': 'Bearer ' + localStorage.getItem('token')
		},
		success: function(evento) {
			callback(evento.nombre);
		},
		error: function(error) {
			console.error('Error al obtener el nombre del evento:', error);
			callback('N/A');
		}
	});
}
