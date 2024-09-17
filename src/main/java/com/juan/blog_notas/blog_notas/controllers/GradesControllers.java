package com.juan.blog_notas.blog_notas.controllers;

import com.juan.blog_notas.blog_notas.entities.Grades;
import com.juan.blog_notas.blog_notas.services.GradesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/grades")

public class GradesControllers {

    @Autowired
    GradesService service;


    //listar notas
    @GetMapping("")
    public List<Grades> list(){
        return service.findAll();
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<?>  view(@PathVariable Long id){
        Optional<Grades> gradesOptional  = service.findById(id);
        if(gradesOptional.isPresent()){
            return ResponseEntity.ok(gradesOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    //crar una nueva nota
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Grades grades, BindingResult result){
//        Grades gradesNew = service.save(grades); //desde el return se crea una nueva nota permitiendo ahorrar lineas de codigo
        if(result.hasFieldErrors()){
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(grades));
    }

    //update nota
    @PutMapping("/{id}")
    public ResponseEntity<?> update( @RequestBody Grades grades, @PathVariable Long id ){
        Optional<Grades> gradesOptional = service.update(id, grades);
        return  ResponseEntity.status(HttpStatus.CREATED).body(gradesOptional.orElseThrow());
    }


    //delete not
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Grades> gradesOptional = service.delete(id);
        return ResponseEntity.ok(gradesOptional.orElseThrow());
    }


    //Validacion (vaidacion por defecto de spring estas deben de ser anotadas en la entidad ensima de cada atributo)
    private ResponseEntity<?> validation (BindingResult result){
        Map<String,String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err ->{
            errors.put(err.getField(), "el campo " + err.getField()+ " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
