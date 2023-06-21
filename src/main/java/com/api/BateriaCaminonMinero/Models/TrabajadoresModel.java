package com.api.BateriaCaminonMinero.Models;

import jakarta.persistence.*;
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
    private Long id_tra;
    private String nom_tra;
    private String ape_tra;
    private String dni_tra;
    private Boolean est_tra;


    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id_emp", nullable = false)
    private  EmpresasModel empresasModel;

}
