package com.example.crudPersona.services.impl;


import com.example.crudPersona.BD.SimulacionBaseDatos;
import com.example.crudPersona.models.Persona;
import com.example.crudPersona.models.dto.PersonaDTO;
import com.example.crudPersona.services.interfaces.IPersona;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaImpl implements IPersona {

    //Inicializacion de la base de datos :3, este objeto es el repo
    private SimulacionBaseDatos bd = new SimulacionBaseDatos();
    //private SimulacionBaseDatos bd = new SimulacionBaseDatos(true);

    @Override
    public boolean agregarPersona(PersonaDTO persona) {
        if(this.bd.save(persona)){
            //Si no hubo error
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Persona buscarPersona(int id) {
        return this.bd.findById(id);
    }

    @Override
    public boolean editarPersona(int id,PersonaDTO persona) {
        if(persona == null){
          return false;
        }else{
            return this.bd.update(id,persona);
        }
    }

    @Override
    public boolean eliminarPersona(int id) {
        return this.bd.delete(id);
    }

    @Override
    public List<Persona> getPersonas() {
        if(this.bd.getBaseDatos().size() <= 0){
            return new ArrayList<Persona>();//Devuelvo una lista vacia
        }else{
            return this.bd.getBaseDatos();
        }
    }
}
