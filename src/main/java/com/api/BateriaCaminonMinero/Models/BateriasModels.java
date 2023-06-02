package com.api.BateriaCaminonMinero.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Baterias")
public class BateriasModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_bat;
    private String nom_bat;
    private Boolean est_bat;

    @ManyToOne
    @JoinColumn(name = "cam_id", referencedColumnName = "id_cam", nullable = false)
    private CamionesModel camionesModel;
}
