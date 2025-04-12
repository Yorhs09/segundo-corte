package com.example.Papeleria.Repository;

import com.example.Papeleria.Model.Producto;
import com.example.Papeleria.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {

        @Query(value = "SELECT v.* FROM venta v WHERE v.empleado_id = :empleadoId", nativeQuery = true)
        List<Venta> findVentasByEmpleadoId(@Param("empleadoId") Long empleadoId);


        @Query(value = "SELECT v.* FROM venta v WHERE v.empleado_id = :empleadoId AND v.cliente_id = :clienteId", nativeQuery = true)
        List<Venta> findVentasByEmpleadoIdAndClienteId(@Param("empleadoId") Long empleadoId, @Param("clienteId") Long clienteId);

}