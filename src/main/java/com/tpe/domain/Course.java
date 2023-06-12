package com.tpe.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Please provide coursename") //" " kabul eder ama NotNull " " kabul etmez
    private String coursename;

    @NotEmpty(message = "Please provide prefix")
    private String prefix;

    @NotNull(message = "Please provide code")
    private Integer code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
