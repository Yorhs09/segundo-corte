package com.example.BDPostgres.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @ManyToMany(mappedBy = "asignaturas")
    private List<Estudiante> estudiantes;

    @ManyToMany
    @JoinTable(
            name = "asignatura_curso",
            joinColumns = @JoinColumn(name = "asignatura_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso>cursos;




}
