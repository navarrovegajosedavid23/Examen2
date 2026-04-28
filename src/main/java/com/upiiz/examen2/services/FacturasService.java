package com.upiiz.examen2.services;

import com.upiiz.examen2.entities.FacturasEntity;
import java.util.List;
import java.util.Optional;

public interface FacturasService {
    // Listar todas
    List<FacturasEntity> listarFacturas();

    // Guardar o Actualizar
    FacturasEntity crearFactura(FacturasEntity factura);

    // Buscar por ID
    Optional<FacturasEntity> obtenerFacturaPorId(Long id);

    // Eliminar
    void eliminarFactura(Long id);
}