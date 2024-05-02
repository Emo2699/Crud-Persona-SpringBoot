package com.example.crudPersona.controllers.apiV1;


import com.example.crudPersona.models.Persona;
import com.example.crudPersona.models.dto.PersonaDTO;
import com.example.crudPersona.services.interfaces.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1") //(api/v1/persona)
public class PersonaController {

    //Inyeccion de la dependencia del servicio en el controlador
    @Autowired
    private IPersona servicio;

    //Agregar persona
    @PostMapping("personas")
    public ResponseEntity<Map<String,Object>>agregarPersona(@RequestBody PersonaDTO nuevo){
        Map<String,Object> json = new HashMap<>();
        if(this.servicio.agregarPersona(nuevo)){
            json.put("message","Usuario agregado con exito 7u7");
            json.put("status",HttpStatus.CREATED);
            return new ResponseEntity<>(json,HttpStatus.CREATED);
        }else{
            json.put("message","Error al agregar persona");
            json.put("status",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(json,HttpStatus.BAD_REQUEST);
        }
    }

    //Buscar persona
    @GetMapping("personas/{id}")
    public ResponseEntity<Map<String, Object>>consultarPersona(@PathVariable int id){
        Map<String, Object> json = new HashMap<>();
        Persona query = this.servicio.buscarPersona(id);
        if(query == null){
            json.put("message","No existe registro con ese id");
            json.put("status",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(json,HttpStatus.BAD_REQUEST);
        }else{
            json.put("data",query);
            json.put("status",HttpStatus.OK);
            return new ResponseEntity<>(json,HttpStatus.OK);
        }
    }


    @PutMapping("personas/{id}")
    public ResponseEntity<Map<String, Object>>actualizarPersona(@PathVariable int id,@RequestBody PersonaDTO nuevo){
        Map<String, Object> json = new HashMap<>();
        if(this.servicio.editarPersona(id,nuevo)){
            json.put("message","La actualizacion fue exitosa.");
            json.put("status",HttpStatus.OK);
            return new ResponseEntity<>(json, HttpStatus.OK);
        }else{
            json.put("message","Error en la actualizacion");
            json.put("status",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("personas/{id}")
    public ResponseEntity<Map<String, Object>>eliminarPersona(@PathVariable int id){
        Map<String,Object> json = new HashMap<>();
        if(this.servicio.eliminarPersona(id)){
            json.put("message", "La persona se elimino correctamente");
            json.put("status", HttpStatus.OK);
            return new ResponseEntity<>(json,HttpStatus.OK);
        }else{
            json.put("message", "Error en la eliminacion");
            json.put("status",HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(json,HttpStatus.BAD_REQUEST);
        }
    }


    //Listado de las personas
    @GetMapping("personas")
    public ResponseEntity<Map<String,Object>> verPersonas(){
        Map<String,Object> json = new HashMap<>();
        List<Persona> query = this.servicio.getPersonas();
        if(query.isEmpty()){
            //Construyendo la respuesta
            json.put("data",query);
            json.put("message","No hay registros");
            json.put("status", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(json,HttpStatus.OK);
        }else{
            json.put("data",query);
            json.put("status", HttpStatus.OK);
            return new ResponseEntity<>(json,HttpStatus.OK);
        }
    }

}
