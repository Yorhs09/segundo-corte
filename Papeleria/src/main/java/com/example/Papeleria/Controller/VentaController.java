package com.example.Papeleria.Controller;

import com.example.Papeleria.Model.Venta;
import com.example.Papeleria.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    private final VentaService ventaService;

    @Autowired
    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public ResponseEntity<Venta> realizarVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = ventaService.realizarVenta(venta);
        return new ResponseEntity<>(nuevaVenta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable Long id) {
        Optional<Venta> venta = ventaService.obtenerVentaPorId(id);
        return venta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Venta>> obtenerTodasVentas() {
        List<Venta> ventas = ventaService.obtenerTodasVentas();
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<Venta>> listarVentasPorFecha(@RequestParam LocalDate fecha) {
        List<Venta> ventas = ventaService.listarVentasPorFecha(fecha);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarVenta(@PathVariable Long id) {
        ventaService.cancelarVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}