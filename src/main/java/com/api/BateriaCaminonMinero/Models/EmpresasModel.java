package com.api.BateriaCaminonMinero.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Empresas")
public class EmpresasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_emp;
    private String nom_emp;
    private Boolean est_emp;

    @JsonIgnore
    @OneToMany(mappedBy = "empresasModel")
    private List<TrabajadoresModel> trabajadores;

    public EmpresasModel() {
    }

    public Long getId_emp() {
        return id_emp;
    }

    public void setId_emp(Long id_emp) {
        this.id_emp = id_emp;
    }

    public String getNom_emp() {
        return nom_emp;
    }

    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }

    public Boolean getEst_emp() {
        return est_emp;
    }

    public void setEst_emp(Boolean est_emp) {
        this.est_emp = est_emp;
    }

    public List<TrabajadoresModel> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<TrabajadoresModel> trabajadores) {
        this.trabajadores = trabajadores;
    }
}
