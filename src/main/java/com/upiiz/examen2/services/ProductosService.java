package com.upiiz.examen2.services;

import com.upiiz.examen2.entities.ProductosEntity;
import java.util.List;
import java.util.Optional;

public interface ProductosService {
    List<ProductosEntity> listarProductos();
    ProductosEntity crearProducto(ProductosEntity producto);
    ProductosEntity actualizarProducto(ProductosEntity producto);
    void eliminarProducto(Long id);
    Optional<ProductosEntity> getProductoPorId(Long id);
}