package com.upiiz.examen2.services;

import com.upiiz.examen2.entities.FacturasEntity;
import com.upiiz.examen2.repositories.FacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturasServicelmpl implements FacturasService {

    @Autowired
    private FacturasRepository facturasRepository;

    @Override
    public List<FacturasEntity> listarFacturas() {
        return facturasRepository.findAll();
    }

    @Override
    public FacturasEntity crearFactura(FacturasEntity factura) {
        return facturasRepository.save(factura);
    }

    @Override
    public Optional<FacturasEntity> obtenerFacturaPorId(Long id) {
        return facturasRepository.findById(id);
    }

    @Override
    public void eliminarFactura(Long id) {
        facturasRepository.deleteById(id);
    }
}