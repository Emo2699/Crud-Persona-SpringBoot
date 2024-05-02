package com.example.crudPersona.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonaDTO implements Serializable {

    private String nombre;
    private String apellidos;
    private int edad;
    private String direccion;
    private String trabajo;
}
