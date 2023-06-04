package com.api.BateriaCaminonMinero.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Roles")
public class RolesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_rol;
    private String nom_rol;
    private Boolean est_rol;
    @JsonIgnore
    @OneToMany(mappedBy = "rolesModel")
    private List<UsuariosModel> usuarios;

    public RolesModel() {
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getNom_rol() {
        return nom_rol;
    }

    public void setNom_rol(String nom_rol) {
        this.nom_rol = nom_rol;
    }

    public Boolean getEst_rol() {
        return est_rol;
    }

    public void setEst_rol(Boolean est_rol) {
        this.est_rol = est_rol;
    }

    public List<UsuariosModel> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuariosModel> usuarios) {
        this.usuarios = usuarios;
    }
}
