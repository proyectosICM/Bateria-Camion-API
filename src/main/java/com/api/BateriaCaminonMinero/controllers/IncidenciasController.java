package com.api.BateriaCaminonMinero.controllers;

import com.api.BateriaCaminonMinero.models.CamionesModel;
import com.api.BateriaCaminonMinero.models.EmpresasModel;
import com.api.BateriaCaminonMinero.models.IncidenciasModel;
import com.api.BateriaCaminonMinero.services.IncidenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<IncidenciasModel> GetAll(){ return incidenciasService.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<IncidenciasModel> GetById(@PathVariable Long id){
        Optional<IncidenciasModel> incidencias = incidenciasService.findById(id);
        if (incidencias.isPresent()){
            return new ResponseEntity<>(incidencias.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/camion/{id}")
    public List<IncidenciasModel> findByCamionesModelId(@PathVariable Long id){
        return incidenciasService.findByCamionesModelId(id);
    }

    @GetMapping("/camion-page/{id}")
    public Page<IncidenciasModel> findByCamionesModelId(@PathVariable Long id,
                                                        @RequestParam (defaultValue = "0") int page,
                                                        @RequestParam (defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page,size);
        return incidenciasService.findByCamionesModelIdOrdered(id, pageable);
    }

    @GetMapping("/empresa/{id}")
    public List<IncidenciasModel> findByEmpresasModelIdOrdered(@PathVariable Long id){
        return incidenciasService.findByEmpresasModelIdOrdered(id);
    }

    @GetMapping("/empresa-page/{id}")
    public Page<IncidenciasModel> findByEmpresasModelIdOrdered(@PathVariable Long id,
                                                               @RequestParam (defaultValue = "0") int page,
                                                               @RequestParam (defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page,size);
        return incidenciasService.findByEmpresasModelIdOrdered(id, pageable);
    }

    /** **/


    @GetMapping("/camSR/{estado}/{id}")
    public List<IncidenciasModel> GetIncCamxEst(@PathVariable Long id, @PathVariable Boolean estado){
        CamionesModel camionesModel = new CamionesModel();
        camionesModel.setId(id);
        return incidenciasService.ListarIncxCamEst(camionesModel, estado);
    }

    @GetMapping("empSR/{estado}/{id}")
    public List<IncidenciasModel> GetIncEmpxEst(@PathVariable Long id, @PathVariable Boolean estado){
        EmpresasModel empresa = new EmpresasModel();
        empresa.setId(id);
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

    @PutMapping("revisado/{id}")
    public ResponseEntity<IncidenciasModel> RevisadoPor(@RequestBody IncidenciasModel incidenciasModel, @PathVariable Long id){
        IncidenciasModel rincidencia = incidenciasService.RevisadoPor(incidenciasModel, id);
        if (rincidencia!=null){
            return new ResponseEntity<>(rincidencia, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
