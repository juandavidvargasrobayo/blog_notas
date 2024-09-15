package com.juan.blog_notas.blog_notas.services;

import com.juan.blog_notas.blog_notas.entities.Grades;
import com.juan.blog_notas.blog_notas.repositories.GradesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class GradesServiceImpl  implements GradesService {
    @Autowired
    GradesRepository repository;

    //listar notas
    @Transactional(readOnly = true)
    @Override
    public List<Grades> findAll(){
        return  (List<Grades>) repository.findAll();
    }

    //Buscar notas

    @Transactional(readOnly = true)
    @Override
    public Optional<Grades> findById(Long id){
        return repository.findById(id);
    }

    //Crear notas
    @Transactional
    @Override
    public Grades save(Grades grades){
        return repository.save(grades);
    }

    //Update notas
    @Transactional
    @Override
    public  Optional<Grades> update(Long id, Grades grades){
        Optional<Grades> gradesOptional = repository.findById(id);
        if (gradesOptional.isPresent()){
            Grades gradesdb = gradesOptional.orElseThrow();
            gradesdb.setTitle(grades.getTitle());
            gradesdb.setContent(grades.getContent());
            return  Optional.of(repository.save(gradesdb));
        }
        return null;
    }

    //delete notoas

    @Transactional
    @Override
    public Optional<Grades> delete(Long id){
        Optional<Grades> gradesOptional = repository.findById(id);
        gradesOptional.ifPresent(gradesDb -> {
            repository.delete(gradesDb);
        });
        return gradesOptional;
    }

}
