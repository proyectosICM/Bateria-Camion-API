package com.api.BateriaCaminonMinero.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Trabajadores")
public class TrabajadoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_tra;
    @NotBlank
    private String nom_tra;
    private String ape_tra;
    private String dni_tra;
    private Boolean estado;
    @NotBlank
    private String username;
    @NotBlank
    private String pass_tra;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RolesModel.class, cascade = CascadeType.PERSIST)
    @JoinTable(name = "trabajadores_roles", joinColumns = @JoinColumn(name = "tra_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<RolesModel> roles;

    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id_emp", nullable = true)
    private  EmpresasModel empresasModel;
}
