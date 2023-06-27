package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.IncidenciasModel;
import com.api.BateriaCaminonMinero.Services.CamionesService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CamionesModel> Getall(){
        return camionesService.ListarCamiones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CamionesModel> GetById(@PathVariable Long id){
        Optional<CamionesModel> camiones = camionesService.ListarCamionId(id);
        if (camiones.isPresent()){
            return new ResponseEntity<>(camiones.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("habxemp/{estado}/{id}")
    public List<CamionesModel> GetCamEmpxEst(@PathVariable Long id, @PathVariable Boolean estado){
        EmpresasModel empresa = new EmpresasModel();
        empresa.setId_emp(id);
        return camionesService.ListarCamionesxEmpresaEst(empresa, estado);
    }

    @GetMapping("camxemp/{id}")
    public List<CamionesModel> GetCamEmp(@PathVariable Long id){
        EmpresasModel empresa = new EmpresasModel();
        empresa.setId_emp(id);
        return camionesService.ListarCamionesxEmpresa((empresa));
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

    @DeleteMapping("/{id}")
    public ResponseEntity<CamionesModel> DCam(@PathVariable Long id){
        camionesService.EliminarCamion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
