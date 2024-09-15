package com.juan.blog_notas.blog_notas.services;

import com.juan.blog_notas.blog_notas.entities.Grades;

import java.util.List;
import java.util.Optional;

public interface GradesService {

    //Listar notas
    List<Grades> findAll();

    //Buscar notas
    Optional<Grades> findById(Long id);

    //save notas
    Grades save(Grades grades);

    //Update notas
    Optional<Grades> update(Long id, Grades grades);

    //delete notas
    Optional<Grades> delete(Long id);

}
