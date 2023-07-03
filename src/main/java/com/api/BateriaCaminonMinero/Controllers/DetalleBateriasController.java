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

    @GetMapping
    public List<DetalleBateriasModel> GetAll(){
        return detalleBateriasService.ListarDetalles();
    }

    @GetMapping("bateriaxdetalle/{bateria}")
    public List<DetalleBateriasModel> GetBatxDet(@PathVariable("bateria") Long bateria){
        return detalleBateriasService.ListarBateriaxDetalle(bateria);
    }

}
