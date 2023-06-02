package com.api.BateriaCaminonMinero.Models;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "DetalleCamiones")
public class DetallesCamionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_dc;

    @Temporal(TemporalType.DATE)
    private Date dia;

    @Temporal(TemporalType.TIME)
    private Time hora;

    @ManyToOne
    @JoinColumn(name = "bat_id", referencedColumnName = "id_bat", nullable = false)
    private BateriasModels bateriasModels;
    private Double voltaje;
    private Integer carga;
    private Double temperatura;
    private Boolean est_dc;

}
