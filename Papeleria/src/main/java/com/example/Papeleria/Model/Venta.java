package com.example.Papeleria.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_venta;
    private LocalDate fecha;

    @OneToMany(mappedBy = "id_detalle")
    private List<Detalle_venta> detalleVentas;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


}
