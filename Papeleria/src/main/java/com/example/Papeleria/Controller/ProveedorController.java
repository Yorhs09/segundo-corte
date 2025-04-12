package com.example.Papeleria.Controller;

import com.example.Papeleria.Model.Proveedor;
import com.example.Papeleria.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    @Autowired
    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @PostMapping
    public ResponseEntity<Proveedor> registrarProveedor(@RequestBody Proveedor proveedor) {
        Proveedor nuevoProveedor = proveedorService.registrarProveedor(proveedor);
        return new ResponseEntity<>(nuevoProveedor, HttpStatus.CREATED);
    }

    @GetMapping("/{nit}")
    public ResponseEntity<Proveedor> obtenerProveedorPorNit(@PathVariable String nit) {
        Optional<Proveedor> proveedor = proveedorService.obtenerProveedorPorNit(nit);
        return proveedor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> listarProveedores() {
        List<Proveedor> proveedores = proveedorService.listarProveedores();
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @PutMapping("/{nit}")
    public ResponseEntity<Proveedor> actualizarInformacion(@PathVariable String nit, @RequestBody Proveedor proveedor) {
        Proveedor proveedorActualizado = proveedorService.actualizarInformacion(nit, proveedor);
        if (proveedorActualizado != null) {
            return new ResponseEntity<>(proveedorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{nit}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable String nit) {
        proveedorService.eliminarProveedor(nit);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}