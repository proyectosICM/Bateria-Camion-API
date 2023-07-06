package com.api.BateriaCaminonMinero.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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
    private Long id_inc;

    @Temporal(TemporalType.DATE)
    private Date dia;

    @Temporal(TemporalType.TIME)
    private Time hora;
    private String nom_inc;

    @ManyToOne
    @JoinColumn(name = "bat_id", referencedColumnName = "id_bat", nullable = false)
    private BateriasModels bateriasModels;

    @ManyToOne
    @JoinColumn(name = "cam_id", referencedColumnName = "id_cam", nullable = false)
    private CamionesModel camionesModel;

    @ManyToOne
    @JoinColumn(name = "conductor", referencedColumnName = "id_tra", nullable = false)
    private TrabajadoresModel conductor;

    @ManyToOne
    @JoinColumn(name = "revisadoBy", referencedColumnName = "id_tra", nullable = true)
    private TrabajadoresModel revisadoBy;

    @Column(nullable = true)
    private Boolean prioridad;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "id_emp", nullable = false)
    private EmpresasModel empresasModel;

    private Double voltaje;
    private Integer carga;
    private Double corriente;
    private Double temperatura;
    private Boolean estado;

}
