package com.example.crudPersona.BD;

import com.example.crudPersona.models.Persona;
import com.example.crudPersona.models.dto.PersonaDTO;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class SimulacionBaseDatos {

    private List<Persona> baseDatos = new ArrayList<>();

    public SimulacionBaseDatos(){

    }

    public SimulacionBaseDatos(boolean bandera){
    }

    //Esta clase tiene los metodos del CRUD
    public boolean save(PersonaDTO persona){
        Persona registro = new Persona(persona);

        //Aqui debe de ir la validacion de la duplicidad

        //Por ahora lo aregaremos sin dicha validacion
        this.baseDatos.add(registro);
        return true;

    }

    public Persona findById(int id){
        if(id <= 0){
            return null;
        }else{
            for(Persona registro:baseDatos){
                if(registro.getId()==id){
                    return registro;
                }
            }
            return null;
        }
    }

    public boolean update(int id,@NotNull PersonaDTO persona){
        Persona registro = findById(id);
        if(registro == null){
            return false;
        }else{
            //Obtengo el indice de dicho objeto dentro de la lista
            int index = this.baseDatos.indexOf(registro);
            //Comienzo a actualizar los valores
            registro.setNombre(persona.getNombre());
            registro.setApellidos(persona.getApellidos());
            registro.setEdad(persona.getEdad());
            registro.setDireccion(persona.getDireccion());
            registro.setTrabajo(persona.getTrabajo());

            //Reemplazo el objeto viejito por el nuevo NO SE MODIFICA NUNCA EL ID
            this.baseDatos.set(index,registro);
            return true;
        }
    }

    public boolean delete(int id){
        Persona registro = findById(id);
        if(registro == null){
            return false;
        }else{
            this.baseDatos.remove(registro);
            return true;
        }
    }


}
