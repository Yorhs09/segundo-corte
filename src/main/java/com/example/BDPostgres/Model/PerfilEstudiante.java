package com.example.BDPostgres.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "perfil_estudiante")
public class PerfilEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String direccion;
    private String telefono;
    private String correo;

    @OneToOne(mappedBy = "perfil")
    private Estudiante estudiante;
}