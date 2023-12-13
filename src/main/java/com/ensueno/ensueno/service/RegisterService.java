package com.ensueno.ensueno.service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ensueno.ensueno.model.Usuario;

public class RegisterService {

    private final String apiUrl = "https://carmensandoval.pythonanywhere.com/usuarios/";

    public void registrarUsuario(Usuario usuario) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Usuario> request = new HttpEntity<>(usuario, headers);

        ResponseEntity<Void> response = restTemplate.postForEntity(apiUrl, request, Void.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Usuario registrado exitosamente");
        } else {
            System.out.println("Error al registrar el usuario. Código de respuesta: " + response.getStatusCodeValue());
        }
    }
}
