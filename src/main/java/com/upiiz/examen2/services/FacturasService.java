package com.upiiz.examen2.services;

import com.upiiz.examen2.entities.FacturasEntity;
import java.util.List;
import java.util.Optional;

public interface FacturasService {
    List<FacturasEntity> listarFacturas();

    FacturasEntity crearFactura(FacturasEntity factura);

    Optional<FacturasEntity> obtenerFacturaPorId(Long id);

    void eliminarFactura(Long id);
}