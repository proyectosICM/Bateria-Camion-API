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

    @ManyToOne
    @JoinColumn(name = "cam_id" , referencedColumnName = "id_cam", nullable = false)
    private CamionesModel camionesModel;

    @Temporal(TemporalType.DATE)
    private Date dia;

    @Temporal(TemporalType.TIME)
    private Time hora;
    private Double voltaje;
    private Integer bateria;
    private Double temperatura;
    private Boolean est_dc;

}
