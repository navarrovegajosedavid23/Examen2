package com.upiiz.examen2.repositories;

import com.upiiz.examen2.entities.CitasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitasRepository extends JpaRepository<CitasEntity, Long> {
}