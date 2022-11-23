package com.api_java_folcademy.demo.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
public class SaludosController {
    @GetMapping("/hello")
    public String saludo() {
        return "Hola mi nombre es Sofia y esta es mi primer API";
    }

    @PostMapping("/goodbye")
    public String chau() {
        return "Hasta luego devs";
    }
}
