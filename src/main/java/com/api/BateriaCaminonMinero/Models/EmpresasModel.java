package com.api.BateriaCaminonMinero.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Empresas")
public class EmpresasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_emp;
    private String nom_emp;
    private Boolean estado;

    @JsonIgnore
    @OneToMany(mappedBy = "empresasModel")
    private List<TrabajadoresModel> trabajadores;
}
