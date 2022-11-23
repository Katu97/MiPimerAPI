package com.api_java_folcademy.demo.model.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactoDTO {
    private Integer id;
    private String nombre;
    private Integer celular;
}
