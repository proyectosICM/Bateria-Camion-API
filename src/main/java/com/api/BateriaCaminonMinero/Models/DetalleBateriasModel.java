package com.api.BateriaCaminonMinero.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
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
    private Date dia;

    @Temporal(TemporalType.TIME)
    private Time hora;

    @ManyToOne
    @JoinColumn(name = "baterteria", referencedColumnName = "id", nullable = false)
    private BateriasModels bateriasModels;
    private Double voltaje;
    private Double Corriente;
    private Integer carga;
    private Double temperatura;
    private Boolean estado;

}
