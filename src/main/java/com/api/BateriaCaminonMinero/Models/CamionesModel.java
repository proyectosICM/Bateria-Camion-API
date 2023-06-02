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

    public CamionesModel() {
    }

    public Long getId_cam() {
        return id_cam;
    }

    public void setId_cam(Long id_cam) {
        this.id_cam = id_cam;
    }

    public String getPlaca_cam() {
        return placa_cam;
    }

    public void setPlaca_cam(String placa_cam) {
        this.placa_cam = placa_cam;
    }

    public EmpresasModel getEmpresasModel() {
        return empresasModel;
    }

    public void setEmpresasModel(EmpresasModel empresasModel) {
        this.empresasModel = empresasModel;
    }

    public TrabajadoresModel getTrabajadoresModel() {
        return trabajadoresModel;
    }

    public void setTrabajadoresModel(TrabajadoresModel trabajadoresModel) {
        this.trabajadoresModel = trabajadoresModel;
    }

    public Boolean getEst_cam() {
        return est_cam;
    }

    public void setEst_cam(Boolean est_cam) {
        this.est_cam = est_cam;
    }
}
