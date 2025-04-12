package com.example.Papeleria.Service;

import com.example.Papeleria.Model.Producto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {


    public Producto crearProducto(Producto producto) {
        System.out.println("Creating producto: " + producto);
        return producto; // Placeholder
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        System.out.println("Getting producto with ID: " + id);
        return Optional.empty(); // Placeholder
    }

    public List<Producto> buscarProductosPorNombre(String nombre) {
        System.out.println("Searching productos by name: " + nombre);
        return List.of(); // Placeholder
    }

    public Producto actualizarProducto(Producto producto) {
        System.out.println("Updating producto with ID: " + obtenerProductoPorId(producto.getId_producto()) + " with data: " + producto);
        return producto; // Placeholder
    }

    public void eliminarProducto(Long id) {
        System.out.println("Deleting producto with ID: " + id);
    }



    public boolean existeProducto(Long id) {
        return false;
    }




}