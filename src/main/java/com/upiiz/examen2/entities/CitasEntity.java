package com.upiiz.examen2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "citas")
public class CitasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;

    private String paciente;
    private String tratamiento;
    private String fecha;
    private String hora;
    private Double costo;

    public CitasEntity() {
    }

    // Getters y Setters
    public Long getIdCita() { return idCita; }
    public void setIdCita(Long idCita) { this.idCita = idCita; }

    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }

    public String getTratamiento() { return tratamiento; }
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public Double getCosto() { return costo; }
    public void setCosto(Double costo) { this.costo = costo; }
}