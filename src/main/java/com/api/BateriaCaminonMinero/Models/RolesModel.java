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
}
