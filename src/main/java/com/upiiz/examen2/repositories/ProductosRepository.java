package com.upiiz.examen2.repositories;

import com.upiiz.examen2.entities.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<ProductosEntity, Long> {
}