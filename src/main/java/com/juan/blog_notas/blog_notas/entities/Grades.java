package com.juan.blog_notas.blog_notas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "grades")


public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
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
