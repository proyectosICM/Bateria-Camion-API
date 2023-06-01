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
}
