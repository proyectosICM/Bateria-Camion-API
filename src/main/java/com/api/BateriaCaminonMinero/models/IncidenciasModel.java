package com.api.BateriaCaminonMinero.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Incidencias")
public class IncidenciasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dia;

    @Temporal(TemporalType.TIME)
    private Time hora;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "bateria", referencedColumnName = "id", nullable = false)
    private BateriasModel bateriasModel;

    @ManyToOne
    @JoinColumn(name = "camion", referencedColumnName = "id", nullable = false)
    private CamionesModel camionesModel;

    @ManyToOne
    @JoinColumn(name = "conductor", referencedColumnName = "id", nullable = false)
    private TrabajadoresModel conductor;

    @ManyToOne
    @JoinColumn(name = "revisadoBy", referencedColumnName = "id", nullable = true)
    private TrabajadoresModel revisadoBy;

    @Column(nullable = true)
    private Boolean prioridad;

    @ManyToOne
    @JoinColumn(name = "empresa", referencedColumnName = "id", nullable = false)
    private EmpresasModel empresasModel;

    private Double voltaje;

    private Integer carga;

    private Double corriente;

    private Double temperatura;

    private Boolean estado;

}
