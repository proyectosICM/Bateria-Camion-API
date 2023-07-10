package com.api.BateriaCaminonMinero.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Arranques")
public class ArranquesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dia;

    @Temporal(TemporalType.TIME)
    private Time hora;

    @ManyToOne
    @JoinColumn(name = "camion", referencedColumnName = "id_cam", nullable = false)
    private CamionesModel camionesModel;

    @ManyToOne
    @JoinColumn(name = "empresa", referencedColumnName = "id_emp", nullable = false)
    private EmpresasModel empresasModel;

    private Double corriente;
}
