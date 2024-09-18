package com.juan.blog_notas.blog_notas.entities;

import com.juan.blog_notas.blog_notas.validation.IsRequired;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "grades")


public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank //para validacion por defecto de spring
    @IsRequired(message = "{NotBlank.grades.title}")
    private String title;
//    @NotEmpty //para validacion por defecto de spring
    @IsRequired(message = "{NotEmpty.gfrades.content}")
    private String content;

    public Long getId(){
      return id;
    }
    public void setId (Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }


}
