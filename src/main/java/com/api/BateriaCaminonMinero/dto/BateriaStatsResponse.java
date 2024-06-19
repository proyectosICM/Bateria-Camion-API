package com.api.BateriaCaminonMinero.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BateriaStatsResponse {
    private Double voltajeAVG;
    private Double cargaAVG;
    private Double corrienteAVG;
    private Long idCamion;
}
