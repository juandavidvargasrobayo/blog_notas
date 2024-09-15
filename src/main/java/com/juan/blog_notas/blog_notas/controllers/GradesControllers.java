package com.juan.blog_notas.blog_notas.controllers;

import com.juan.blog_notas.blog_notas.entities.Grades;
import com.juan.blog_notas.blog_notas.services.GradesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<?> create(@Valid @RequestBody Grades grades){
//        Grades gradesNew = service.save(grades);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(grades));
    }
}
