package com.api.BateriaCaminonMinero.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Detalle_Baterias")
public class DetalleBateriasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    private LocalDate dia;

    @Temporal(TemporalType.TIME)
    private Time hora;

    @ManyToOne
    @JoinColumn(name = "bateria", referencedColumnName = "id", nullable = false)
    private BateriasModel bateriasModel;

    private Double voltaje;

    private Double Corriente;

    private Integer carga;

    private Double temperatura;

    private Boolean estado;

}
