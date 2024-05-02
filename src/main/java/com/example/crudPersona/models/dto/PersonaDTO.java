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

    public boolean isEmptySomething(){
        if(this.nombre == null || this.nombre.isBlank()){
            return true;
        }
        if(this.apellidos == null || this.apellidos.isBlank()){
            return true;
        }
        if(this.direccion == null || this.direccion.isBlank()){
            return true;
        }
        if(this.trabajo == null || this.trabajo.isBlank()){
            return true;
        }
        if(this.edad<=0){
            return true;
        }
        return false;

    /*
        if(this.nombre.isBlank() || this.apellidos.isBlank() || this.edad <= 0
        || this.direccion.isBlank() || this.trabajo.isBlank()){
            return true;
        }else{
            return false;
        }

     */
    }
}
