package com.api.BateriaCaminonMinero.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Camiones")
public class CamionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_cam;
    private String placa_cam;
    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id_emp", nullable = false)
    private EmpresasModel empresasModel;

    @ManyToOne
    @JoinColumn(name = "tra_id", referencedColumnName = "id_tra", nullable = true)
    private TrabajadoresModel trabajadoresModel;

    private Boolean estado;
}
