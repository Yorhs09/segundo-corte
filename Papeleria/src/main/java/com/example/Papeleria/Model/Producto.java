package com.example.Papeleria.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

    public class Producto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id_producto;
        private String nombre;
        private String descripcion;
        private String precio;
        private int stock;



        @ManyToOne
        @JoinColumn(name = "id_proveedor")
        private Proveedor proveedors;

        @OneToMany(mappedBy = "id_detalle")
        private List<Detalle_venta> detalle_ventas;


        public void setId(Long id) {

        }
    }
