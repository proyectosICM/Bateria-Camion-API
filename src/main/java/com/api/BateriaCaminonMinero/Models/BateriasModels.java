package com.api.BateriaCaminonMinero.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Baterias")
public class BateriasModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_bat;
    private String nom_bat;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "cam_id", referencedColumnName = "id_cam")
    private CamionesModel camionesModel;

    private Double voltaje;
    private Double corriente;
    private Integer carga;
    private Double temperatura;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id_emp")
    private EmpresasModel empresasModel;
}
