package com.example.Papeleria.Controller;

import com.example.Papeleria.Model.Detalle_venta;
import com.example.Papeleria.Service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalles-venta")
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    @Autowired
    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @PostMapping
    public ResponseEntity<Detalle_venta> crearDetalleVenta(@RequestBody Detalle_venta detalleVenta) {
        Detalle_venta nuevoDetalle = detalleVentaService.crearDetalleVenta(detalleVenta);
        return new ResponseEntity<>(nuevoDetalle, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Detalle_venta>> obtenerTodosLosDetallesVenta() {
        List<Detalle_venta> detalles = detalleVentaService.obtenerTodosLosDetallesVenta();
        if (detalles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalle_venta> actualizarDetalleVenta(@PathVariable Long id, @RequestBody Detalle_venta detalleVentaActualizado) {
        Optional<Detalle_venta> detalleExistente = detalleVentaService.obtenerDetalleVentaPorId(id);
        if (detalleExistente.isPresent()) {
            detalleVentaActualizado.setId(id); // Asegurar que el ID sea el correcto
            Detalle_venta detalleActualizadoResult = detalleVentaService.actualizarDetalleVenta(detalleVentaActualizado);
            return new ResponseEntity<>(detalleActualizadoResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarDetalleVenta(@PathVariable Long id) {
        if (detalleVentaService.existeDetalleVenta(id)) {
            detalleVentaService.eliminarDetalleVenta(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ventas/{ventaId}")
    public ResponseEntity<List<Detalle_venta>> obtenerDetallesPorVenta(@PathVariable Long ventaId) {
        List<Detalle_venta> detalles = detalleVentaService.obtenerDetallesPorVenta(ventaId);
        if (detalles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }


}