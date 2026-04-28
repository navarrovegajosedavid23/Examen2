package com.upiiz.examen2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facturas")
public class FacturasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;

    private String Cliente;
    private String razonSocial;
    private LocalDate fecha;
    private Double Total;

    // NUEVOS CAMPOS
    private Integer cantidad;
    private String producto;
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "cita_id", referencedColumnName = "idCita")
    private CitasEntity cita;
}