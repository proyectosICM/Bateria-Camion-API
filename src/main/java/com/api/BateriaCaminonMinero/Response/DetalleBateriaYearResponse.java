package com.api.BateriaCaminonMinero.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleBateriaYearResponse {
    private Integer fecha;
    private Date dia;
    private Double voltaje;
    private BigDecimal carga;
    private Double   cargaA;
    private Double corriente;
    private Double temperatura;
    private Long contador;
}
