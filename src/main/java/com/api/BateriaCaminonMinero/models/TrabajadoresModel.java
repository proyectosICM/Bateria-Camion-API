package com.api.BateriaCaminonMinero.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long id;
    @NotBlank
    private String nombre;
    private String apellido;
    private String dni;
    private Boolean estado;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    @ManyToOne
    @JoinColumn(name = "rol", referencedColumnName = "id", nullable = true)
    private  RolesModel rolesModel;

    @ManyToOne
    @JoinColumn(name = "empresa", referencedColumnName = "id", nullable = true)
    private  EmpresasModel empresasModel;
}
