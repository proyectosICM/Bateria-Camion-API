package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.IncidenciasModel;
import com.api.BateriaCaminonMinero.Repositories.IncidenciasRepository;
import com.api.BateriaCaminonMinero.Services.IncidenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/incidencias")
public class IncidenciasController {
    @Autowired
    IncidenciasService incidenciasService;

    @GetMapping
    public List<IncidenciasModel> GetAll(){ return incidenciasService.ListarIncidencias();}

    @GetMapping("/{id}")
    public ResponseEntity<IncidenciasModel> GetById(@PathVariable Long id){
        Optional<IncidenciasModel> incidencias = incidenciasService.ListarIncidenciaId(id);
        if (incidencias.isPresent()){
            return new ResponseEntity<>(incidencias.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/camion/{id}")
    public List<IncidenciasModel> GetCamionInc(@PathVariable Long id){
        CamionesModel camionesModel = new CamionesModel();
        camionesModel.setId_cam(id);
        return incidenciasService.ListarIncidenciasxCamion(camionesModel);
    }

    @GetMapping("/camSR/{estado}/{id}")
    public List<IncidenciasModel> GetIncCamxEst(@PathVariable Long id, @PathVariable Boolean estado){
        CamionesModel camionesModel = new CamionesModel();
        camionesModel.setId_cam(id);
        return incidenciasService.ListarIncxCamEst(camionesModel, estado);
    }

    @GetMapping("empSR/{estado}/{id}")
    public List<IncidenciasModel> GetIncEmpxEst(@PathVariable Long id, @PathVariable Boolean estado){
        EmpresasModel empresa = new EmpresasModel();
        empresa.setId_emp(id);
        return incidenciasService.ListarIncxEmpEst(empresa, estado);
    }

    @PostMapping
    public ResponseEntity<IncidenciasModel> CrearI(@RequestBody IncidenciasModel incidenciasModel){
        IncidenciasModel cincidencia = incidenciasService.CrearIncidencia(incidenciasModel);
        return new ResponseEntity<>(cincidencia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncidenciasModel> CambiarEstadoI(@RequestBody IncidenciasModel incidenciasModel, @PathVariable Long id){
        IncidenciasModel ceincidencia = incidenciasService.CambiarEstado(incidenciasModel,id);
        if (ceincidencia != null){
            return new ResponseEntity<>(ceincidencia, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
