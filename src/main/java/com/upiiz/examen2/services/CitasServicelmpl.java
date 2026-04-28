package com.upiiz.examen2.services;

import com.upiiz.examen2.entities.CitasEntity;
import com.upiiz.examen2.repositories.CitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitasServicelmpl implements CitasService {

    @Autowired
    private CitasRepository citasRepository;

    @Override
    public List<CitasEntity> listarCitas() {
        return citasRepository.findAll();
    }

    @Override
    public CitasEntity crearCita(CitasEntity cita) {
        return citasRepository.save(cita);
    }

    @Override
    public CitasEntity actualizarCita(CitasEntity cita) {
        return citasRepository.save(cita);
    }

    @Override
    public void eliminarCita(Long id) {
        citasRepository.deleteById(id);
    }

    @Override
    public Optional<CitasEntity> getCitaPorId(Long id) {
        return citasRepository.findById(id);
    }
}