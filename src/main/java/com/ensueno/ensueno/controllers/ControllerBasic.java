package com.ensueno.ensueno.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ControllerBasic {
	
	@GetMapping("/principal")
	public String principal() {
		return "index";
	}
	
	@GetMapping("/nosotros")
	public String nosotros() {
		return "nosotros";
	}
	
	@GetMapping("/galeria_platos")
	public String galeria_platos() {
		return "galeria_platos";
	}
	
	@GetMapping("/galeria_ambientes")
	public String galeria_ambientes() {
		return "galeria_ambientes";
	}
	
	@GetMapping("/carta_pescados")
	public String carta_pescados() {
		return "carta_pescados";
	}
	
	@GetMapping("/carta_criollos")
	public String carta_criollos() {
		return "carta_criollos";
	}
	
	@GetMapping("/carta_bebidas")
	public String carta_bebidas() {
		return "carta_bebidas";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	@GetMapping("/reservas")
	public String reservas() {
		return "reservas";
	}
	
	@GetMapping("/reservas/login")
	public String login_reserva() {
		return "login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/reservas/login/form_reserva")
	public String form_reserva() {
		return "form_reserva";
	}
	

	@GetMapping("/testimonios")
	public String testimonios() {
		return "testimonios";
	}
	
	@GetMapping("/olvidar")
	public String olvidar() {
		return "olvidar";
	}

}