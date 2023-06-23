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
    private Boolean est_bat;

    @ManyToOne
    @JoinColumn(name = "cam_id", referencedColumnName = "id_cam", nullable = false)
    private CamionesModel camionesModel;
    private Double voltaje;
    private Double corriente;
    private Integer carga;
    private Double temperatura;
}
