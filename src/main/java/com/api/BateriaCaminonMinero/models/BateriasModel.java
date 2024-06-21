package com.api.BateriaCaminonMinero.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Baterias")
public class BateriasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "camion", referencedColumnName = "id")
    private CamionesModel camionesModel;

    private Double voltaje;

    private Double corriente;

    private Integer carga;

    private Double temperatura;

    @ManyToOne
    @JoinColumn(name = "empresa", referencedColumnName = "id")
    private EmpresasModel empresasModel;
}
