package com.api.BateriaCaminonMinero.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountResponse {
    private Integer fecha;
    private Long conteo;
    private CamionesModel camionesModel;
}