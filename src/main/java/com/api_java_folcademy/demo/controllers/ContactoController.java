package com.api_java_folcademy.demo.controllers;

import com.api_java_folcademy.demo.model.domain.ContactoDTO;
import com.api_java_folcademy.demo.model.domain.MensajeDTO;
import com.api_java_folcademy.demo.service.ContactoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactos")
public class ContactoController {
    private final ContactoService contactoService;

    public ContactoController(ContactoService contactoService){
        this.contactoService = contactoService;
    }

    @GetMapping
    public ResponseEntity<List<ContactoDTO>> findTodos(){
        return ResponseEntity.ok(contactoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoDTO> findOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(contactoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MensajeDTO> add(@RequestBody ContactoDTO contactoDTO){
        return ResponseEntity.ok(contactoService.add(contactoDTO));
    }

}
