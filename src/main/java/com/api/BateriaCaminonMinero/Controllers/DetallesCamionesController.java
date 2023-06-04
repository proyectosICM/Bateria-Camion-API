package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Services.DetallesCamionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/detalles")
public class DetallesCamionesController {
    @Autowired
    DetallesCamionesService detallesCamionesService;

    @GetMapping("/d/{camion}")
    public List<Object[]> getDetallesValores(@PathVariable("camion") int camion){
        return detallesCamionesService.getDetallesValores(camion);
    }
}
