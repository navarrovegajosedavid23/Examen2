package com.upiiz.examen2.repositories;

import com.upiiz.examen2.entities.FacturasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturasRepository extends JpaRepository<FacturasEntity, Long> {
    // Al heredar de JpaRepository, ya tienes:
    // save(), findAll(), findById(), deleteById(), etc.
}