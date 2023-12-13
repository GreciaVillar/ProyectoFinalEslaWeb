package com.ensueno.ensueno.controllers;

import com.ensueno.ensueno.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        String token = loginService.login(email, password);

        if (token != null) {
            // El login fue exitoso, puedes redirigir a una página de inicio, por ejemplo
            return "redirect:/ensueno/inicio";
        } else {
            // El login falló, puedes redirigir a una página de login con un mensaje de error
            return "redirect:/error";
        }
    }
}

