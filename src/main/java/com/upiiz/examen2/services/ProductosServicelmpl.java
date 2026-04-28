package com.upiiz.examen2.services;

import com.upiiz.examen2.entities.ProductosEntity;
import com.upiiz.examen2.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosServicelmpl implements ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<ProductosEntity> listarProductos() {
        return productosRepository.findAll();
    }

    @Override
    public ProductosEntity crearProducto(ProductosEntity producto) {
        return productosRepository.save(producto);
    }

    @Override
    public ProductosEntity actualizarProducto(ProductosEntity producto) {
        return productosRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        productosRepository.deleteById(id);
    }

    @Override
    public Optional<ProductosEntity> getProductoPorId(Long id) {
        return productosRepository.findById(id);
    }
}