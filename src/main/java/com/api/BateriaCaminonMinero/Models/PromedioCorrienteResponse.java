package com.api.BateriaCaminonMinero.Models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromedioCorrienteResponse {
    private int mes;
    private double promedioCorriente;
    private CamionesModel camionesModel;
    private EmpresasModel empresasModel;
}
