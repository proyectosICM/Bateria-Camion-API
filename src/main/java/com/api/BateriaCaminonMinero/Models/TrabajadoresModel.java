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
}
