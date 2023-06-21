package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.DetalleBateriasModel;
import com.api.BateriaCaminonMinero.Services.DetalleBateriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/detalles")
public class DetalleBateriasController {
    @Autowired
    DetalleBateriasService detalleBateriasService;

    @GetMapping("/d/{camion}")
    public List<Object[]> getDetallesValores(@PathVariable("camion") int camion){
        return detalleBateriasService.getDetallesValores(camion);
    }

    @GetMapping("/bxc/{camion}/{bateria}")
    public List<DetalleBateriasModel> dxc(@PathVariable("camion") int camion, @PathVariable("bateria") int bateria){
        return detalleBateriasService.getDetallesBaterias(camion, bateria);
    }
}
