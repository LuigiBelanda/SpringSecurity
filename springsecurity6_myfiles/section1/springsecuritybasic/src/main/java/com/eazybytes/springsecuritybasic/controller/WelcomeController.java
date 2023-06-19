package com.eazybytes.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Definindo como um controller
@RestController
public class WelcomeController {

    // Dizendo que se recebermos uma requisição GET
    // nesta rota /welcome, devemos retornar o que o método diz
    @GetMapping("/welcome")
    public String sayWelcome(){
        return "Welcome to Spring Application with Security";
    }

}
