package com.api.BateriaCaminonMinero.controllers;

import com.api.BateriaCaminonMinero.models.CamionesModel;
import com.api.BateriaCaminonMinero.models.EmpresasModel;
import com.api.BateriaCaminonMinero.services.CamionesService;
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
@RequestMapping("api/camiones")
public class CamionesController {
    @Autowired
    CamionesService camionesService;

    @GetMapping
    public List<CamionesModel> findAll(){
        return camionesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CamionesModel> findById(@PathVariable Long id){
        Optional<CamionesModel> camiones = camionesService.findById(id);
        if (camiones.isPresent()){
            return new ResponseEntity<>(camiones.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/empresa/{id}")
    public List<CamionesModel> findByEmpresasModelId(@PathVariable Long id){
        return camionesService.findByEmpresasModelId(id);
    }

    @GetMapping("/empresa-page/{id}")
    public Page<CamionesModel> findByEmpresasModelId(@PathVariable Long id,
                                         @RequestParam (defaultValue = "0") int page,
                                         @RequestParam (defaultValue = "8") int size){
        Pageable pageable = PageRequest.of(page, size);
        return camionesService.findByEmpresasModelId(id, pageable);
    }

    /* */



    //Listar camion asociado a un conductor
    @GetMapping("camionxtrabajador/{id}")
    public ResponseEntity<CamionesModel> GetCamxTra(@PathVariable Long id){
        Optional<CamionesModel> camiones = camionesService.ListarCamionxTrabajador(id);
        if(camiones.isPresent()){
            return new ResponseEntity<>(camiones.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("habxemp/{estado}/{id}")
    public List<CamionesModel> GetCamEmpxEst(@PathVariable Boolean estado, @PathVariable Long id){
        EmpresasModel empresa = new EmpresasModel();
        empresa.setId(id);
        return camionesService.ListarCamionesxEmpresaEst(empresa, estado);
    }



    @PostMapping
    public ResponseEntity<CamionesModel> CCam(@RequestBody CamionesModel camionesModel){
        CamionesModel ccamion = camionesService.CrearCamion(camionesModel);
        return new ResponseEntity<>(ccamion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CamionesModel> ECam(@RequestBody CamionesModel camionesModel, @PathVariable Long id){
        CamionesModel ecam = camionesService.EditarCamion(camionesModel, id);
        if (ecam != null) {
            return new ResponseEntity<>(ecam, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/corrinteArranque/{id}")
    public ResponseEntity<CamionesModel> CA(@RequestBody CamionesModel camionesModel, @PathVariable Long id){
        CamionesModel ca = camionesService.EditarCorrienteArranque(camionesModel, id);
        if (ca != null){
            return new ResponseEntity<>(ca, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CamionesModel> DCam(@PathVariable Long id){
        camionesService.EliminarCamion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
