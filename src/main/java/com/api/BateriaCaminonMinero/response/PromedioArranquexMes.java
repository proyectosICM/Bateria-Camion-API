package com.api.BateriaCaminonMinero.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromedioArranquexMes {
    private Date fecha;
    private Double promedio;
    private Long contador;
}
