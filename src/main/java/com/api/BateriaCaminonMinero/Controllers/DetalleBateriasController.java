package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.BateriasModels;
import com.api.BateriaCaminonMinero.Models.DetalleBateriasModel;
import com.api.BateriaCaminonMinero.Services.DetalleBateriasService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("dia/{id}")
    public List<DetalleBateriasModel> obtenerRegistrosPorDia(@PathVariable Long id) {
        return detalleBateriasService.ListarDetallexDia(id);
    }

    @GetMapping("d/{dia}")
    public List<DetalleBateriasModel> obtenerRegistrosD(@PathVariable Date dia) {
        return detalleBateriasService.ListarDetallexD(dia);
    }

    @PostMapping("diab/{id}")
    public ResponseEntity<DetalleBateriasModel> ListarDBateriaxDia(@PathVariable Long id, @RequestBody DetalleBateriasModel detalleBateriasModel ) {
        DetalleBateriasModel deta = detalleBateriasService.ListarDBateriaxDia(id, detalleBateriasModel);
        return new ResponseEntity<>(deta, HttpStatus.OK);
    }

}
