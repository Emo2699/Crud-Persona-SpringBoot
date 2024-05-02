package com.example.crudPersona.services.interfaces;

import com.example.crudPersona.models.Persona;
import com.example.crudPersona.models.dto.PersonaDTO;

import java.util.List;

public interface IPersona {

    boolean agregarPersona(PersonaDTO persona);

    Persona buscarPersona(int id);

    boolean editarPersona(int id,PersonaDTO persona);

    boolean eliminarPersona(int id);

    List<Persona> getPersonas();
}
