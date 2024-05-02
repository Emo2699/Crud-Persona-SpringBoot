package com.example.crudPersona.BD;

import com.example.crudPersona.models.Persona;
import com.example.crudPersona.models.dto.PersonaDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimulacionBaseDatosTest {

    private SimulacionBaseDatos bdTest;



    @BeforeEach
    public void iniciarBaseDatosTes(){
        this.bdTest = new SimulacionBaseDatos();
    }


    //Prueba para metodo listar
    @Test
    public void getListaPersonasTest(){
        List<Persona> resultado = this.bdTest.getBaseDatos();
        assertInstanceOf(List.class, resultado);
        System.out.println("@Test -> getListaPersonasTest()");
    }


    //Prueba metodo buscar con resultado nulo
    @Test
    public void findByIdNullResponseTest(){
        Persona resultado = this.bdTest.findById(1);
        assertNull(resultado);
        System.out.println("@Test -> findByIdNullResponseTest()");
    }

    @Test
    public void findByIdResponseTest(){
        PersonaDTO persona = new PersonaDTO("Erick","Ramirez",25,"Direccion1","Ingeniero");
        this.bdTest.save(persona);
        Persona resultado = this.bdTest.findById(1);
        assertNotNull(resultado);
        System.out.println("@Test -> findByIdResponseTest()");
    }




    //Prueba de agregar con DTO valido
    @Test
    public void agregarPersonaInputValidTest(){
        PersonaDTO persona = new PersonaDTO("Erick","Ramirez",25,"Direccion1","Ingeniero");
        assertTrue(this.bdTest.save(persona));
        System.out.println("@Test -> agregarPersonaInputValidTest()");

    }
    //Prueba de agregar con DTO invalido
    @Test
    public void agregarPersonaInputInvalidTest(){
        PersonaDTO persona = new PersonaDTO();
        assertFalse(this.bdTest.save(persona));
        System.out.println("@Test -> agregarPersonaInputInvalidTest()");

    }


    /*Prueba de eliminacion de un registro inexistente*/
    @Test
    public void eliminarPersonaInexistenteTest(){
        assertFalse(this.bdTest.delete(1));
        System.out.println("@Test -> eliminarPersonaInexistenteTest()");
    }


    @AfterEach
    public void tearDown(){
        this.bdTest = null;
    }


}