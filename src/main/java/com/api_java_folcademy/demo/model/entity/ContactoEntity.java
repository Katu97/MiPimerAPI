package com.api_java_folcademy.demo.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="contactos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Contactos")
public class ContactoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT UNSIGNED")
    private Integer id;

    @Column(name = "nombre", columnDefinition = "VARCHAR(50)")
    private String nombre;

    @Column(name = "celular", columnDefinition = "INT UNSIGNED")
    private Integer celular;
}
