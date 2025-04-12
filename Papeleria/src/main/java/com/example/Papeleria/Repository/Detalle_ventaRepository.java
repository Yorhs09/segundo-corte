package com.example.Papeleria.Repository;

import com.example.Papeleria.Model.Detalle_venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface Detalle_ventaRepository extends JpaRepository<Detalle_venta, Long> {

        @Query(value = "SELECT dv.* FROM detalle_venta dv " +
                "JOIN venta v ON dv.venta_id = v.id " +
                "WHERE v.empleado_id = :empleadoId AND v.cliente_id = :clienteId", nativeQuery = true)
        List<Detalle_venta> findDetallesVentaByEmpleadoIdAndClienteId(
                @Param("empleadoId") Long empleadoId,
                @Param("clienteId") Long clienteId
        );

}