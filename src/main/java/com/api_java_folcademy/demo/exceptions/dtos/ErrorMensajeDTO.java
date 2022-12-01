package com.api_java_folcademy.demo.exceptions.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMensajeDTO {
    private String mensaje;
    private Integer codigoError;
}
