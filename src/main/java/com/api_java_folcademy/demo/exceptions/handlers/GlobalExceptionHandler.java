package com.api_java_folcademy.demo.exceptions.handlers;


import com.api_java_folcademy.demo.exceptions.dtos.ErrorMensajeDTO;
import com.api_java_folcademy.demo.exceptions.exceptiosKinds.ContactoInexistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ErrorMensajeDTO> defaultErrorHandler(HttpServletRequest reg, Exception e){
        return new ResponseEntity<>(new ErrorMensajeDTO(e.getMessage(), 1001), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ContactoInexistenteException.class)
    @ResponseBody
    public ResponseEntity<ErrorMensajeDTO> notFoundExceptionHandler(HttpServletRequest reg, Exception e){
        return new ResponseEntity<>(new ErrorMensajeDTO(e.getMessage(), 1002), HttpStatus.NOT_FOUND);
    }
}


