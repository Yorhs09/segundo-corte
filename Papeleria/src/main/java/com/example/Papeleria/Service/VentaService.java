package com.example.Papeleria.Service;

import com.example.Papeleria.Model.Venta;
import com.example.Papeleria.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {


    private final com.example.Papeleria.Repository.VentaRepository VentaRepository;

    public Venta realizarVenta(Venta venta) {
        // Implement the complex logic for creating a sale,
        // including creating DetalleVenta entries and updating product stock.
        System.out.println("Realizando venta: " + venta);
        return venta; // Placeholder
    }

    public Optional<Venta> obtenerVentaPorId(Long id) {
        System.out.println("Getting venta with ID: " + id);
        return Optional.empty(); // Placeholder
    }

    public List<Venta> listarVentasPorFecha(LocalDate fecha) {
        System.out.println("Listing ventas for date: " + fecha);
        return List.of(); // Placeholder
    }

    public void cancelarVenta(Long id) {
        System.out.println("Canceling venta with ID: " + id);
    }

    public List<Venta> obtenerTodasVentas() {
        System.out.println("Getting all ventas");
        return List.of(); // Placeholder
    }
    @Autowired
    public VentaService(VentaRepository ventaRepository) {
        this.VentaRepository = ventaRepository;
    }
    
    public List<Venta> obtenerVentasPorEmpleado(Long empleadoId) {
        return VentaRepository.findVentasByEmpleadoId(empleadoId);
    }

    public List<Venta> obtenerVentasPorEmpleadoYCliente(Long empleadoId, Long clienteId) {
        return VentaRepository.findVentasByEmpleadoIdAndClienteId(empleadoId, clienteId);
    }
}
