package com.api.BateriaCaminonMinero.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Trabajadores")
public class TrabajadoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_tra;
    private String nom_tra;
    private String ape_tra;
    private String dni_tra;
    private Boolean est_tra;


    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id_emp", nullable = false)
    private  EmpresasModel empresasModel;


    @OneToOne
    @JoinColumn(name="usuario_id", referencedColumnName = "id_usu", nullable = false)
    private UsuariosModel usuariosModel;

    public TrabajadoresModel() {
    }

    public Long getId_tra() {
        return id_tra;
    }

    public void setId_tra(Long id_tra) {
        this.id_tra = id_tra;
    }

    public String getNom_tra() {
        return nom_tra;
    }

    public void setNom_tra(String nom_tra) {
        this.nom_tra = nom_tra;
    }

    public String getApe_tra() {
        return ape_tra;
    }

    public void setApe_tra(String ape_tra) {
        this.ape_tra = ape_tra;
    }

    public String getDni_tra() {
        return dni_tra;
    }

    public void setDni_tra(String dni_tra) {
        this.dni_tra = dni_tra;
    }

    public Boolean getEst_tra() {
        return est_tra;
    }

    public void setEst_tra(Boolean est_tra) {
        this.est_tra = est_tra;
    }

    public EmpresasModel getEmpresasModel() {
        return empresasModel;
    }

    public void setEmpresasModel(EmpresasModel empresasModel) {
        this.empresasModel = empresasModel;
    }

    public UsuariosModel getUsuariosModel() {
        return usuariosModel;
    }

    public void setUsuariosModel(UsuariosModel usuariosModel) {
        this.usuariosModel = usuariosModel;
    }
}
