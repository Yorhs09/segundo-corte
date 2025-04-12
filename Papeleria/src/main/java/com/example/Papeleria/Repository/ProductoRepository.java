package com.example.Papeleria.Repository;

import com.example.Papeleria.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

        @Query(value = "SELECT p.* FROM producto p WHERE p.proveedor_id = :proveedorId", nativeQuery = true)
        List<Producto> findProductosByProveedorId(@Param("proveedorId") Long proveedorId);

}