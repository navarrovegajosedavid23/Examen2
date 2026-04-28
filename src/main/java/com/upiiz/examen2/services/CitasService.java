package com.upiiz.examen2.services;

import com.upiiz.examen2.entities.CitasEntity;
import java.util.List;
import java.util.Optional;

public interface CitasService {
    List<CitasEntity> listarCitas();
    CitasEntity crearCita(CitasEntity cita);
    CitasEntity actualizarCita(CitasEntity cita);
    void eliminarCita(Long id);
    Optional<CitasEntity> getCitaPorId(Long id);
}