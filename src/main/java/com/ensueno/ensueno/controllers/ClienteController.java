package com.ensueno.ensueno.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ensueno")
public class ClienteController {
	
	@GetMapping("/inicio")
	public String inicio() {
		return "index2";
	}
	
	@GetMapping("/gestionar")
	public String gestionar() {
		return "gestionar";
	}
	
	@GetMapping("/pescados")
	public String pescados() {
		return "carta_pescados_mariscos";
	}
	
	@GetMapping("/criollos")
	public String criollos() {
		return "criollos";
	}
	
	@GetMapping("/bebidas")
	public String bebidas() {
		return "bebidas";
	}
	
	@GetMapping("/mis_testimonios")
	public String mis_testimonios() {
		return "mistestimonios";
	}
	
	@GetMapping("/reservar")
	public String reservar() {
		return "formulario_reservas";
	}
	
	@GetMapping("/agregar_testimonio")
	public String agregar_testimonio() {
		return "formulario_testimonios";
	}
	
	@GetMapping("/editar")
	public String editar(){
		return "editar";
	}

}
