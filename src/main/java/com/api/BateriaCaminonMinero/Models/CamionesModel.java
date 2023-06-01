package com.api.BateriaCaminonMinero.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "Camiones")
public class CamionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_cam;
    private String placa_cam;
    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id_emp", nullable = false)
    private EmpresasModel empresasModel;

    @ManyToOne
    @JoinColumn(name = "tra_id", referencedColumnName = "id_tra", nullable = false)
    private TrabajadoresModel trabajadoresModel;

    private Boolean est_cam;

}
