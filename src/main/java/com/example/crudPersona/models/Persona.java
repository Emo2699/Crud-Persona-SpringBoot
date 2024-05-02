package com.example.crudPersona.models;


import com.example.crudPersona.models.dto.PersonaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Persona implements Serializable {

    private static int contadorID = 0;

    //Atributos
    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    private String direccion;
    private String trabajo;

    //Constructor a partir de un DTO
    public Persona(@NotNull PersonaDTO dto){
        contadorID += 1;
        this.id = contadorID;
        this.nombre = dto.getNombre();
        this.apellidos = dto.getApellidos();
        this.edad = dto.getEdad();
        this.direccion = dto.getDireccion();
        this.trabajo = dto.getTrabajo();
    }
}
