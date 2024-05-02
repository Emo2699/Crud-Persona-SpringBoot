package com.example.crudPersona.models.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaDTOTest {


    //Prueba con un objeto que es nulo
    @Test
    void isEmptySomethingEmptyInputTest() {
        PersonaDTO persona = new PersonaDTO();
        assertTrue(persona.isEmptySomething());
        System.out.println("@Test -> isEmptySomethingEmptyInputTest()");
    }

    @Test
    void isEmptySomethingNotEmptyInputTest() {
        PersonaDTO persona = new PersonaDTO("Nombre","Apellidos",5,"Direccion","Trabajo");
        assertFalse(persona.isEmptySomething());
        System.out.println("@Test -> isEmptySomethingNotEmptyInputTest()");
    }

    /*En esta prueba se mandará un argumento null*/
    @Test
    void isEmptySomethingNotEmptyInputTestv2() {
        PersonaDTO persona = new PersonaDTO(null,"Apellidos",5,"Direccion","Trabajo");
        assertTrue(persona.isEmptySomething());
        System.out.println("@Test -> isEmptySomethingNotEmptyInputTestv2()");
    }

    /*En esta prueba se mandará la edad en 0*/
    @Test
    void isEmptySomethingNotEmptyInputTestv3() {
        PersonaDTO persona = new PersonaDTO("null","Apellidos",0,"Direccion","Trabajo");
        assertTrue(persona.isEmptySomething());
        System.out.println("@Test -> isEmptySomethingNotEmptyInputTestv3()");
    }
}