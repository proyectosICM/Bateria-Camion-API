package com.api.BateriaCaminonMinero.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleBateriaYearResponse {
    private Integer fecha;
    private Double voltaje;
    private Double carga;
    private Double corriente;
    private Double temperatura;
    private Long contador;
}
