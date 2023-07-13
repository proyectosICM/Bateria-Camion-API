package com.api.BateriaCaminonMinero.Response;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
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
