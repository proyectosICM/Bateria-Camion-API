package com.api.BateriaCaminonMinero.controllers;

import com.api.BateriaCaminonMinero.dto.BateriaStatsResponse;
import com.api.BateriaCaminonMinero.models.BateriasModels;
import com.api.BateriaCaminonMinero.models.EmpresasModel;
import com.api.BateriaCaminonMinero.services.BateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/baterias")
public class BateriaController {
    @Autowired
    BateriaService bateriaService;

    @GetMapping
    public List<BateriasModels> findAll(){
        return bateriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BateriasModels> findById(@PathVariable Long id){
        Optional<BateriasModels> bateria = bateriaService.findById(id);
        if (bateria.isPresent()){
            return new ResponseEntity<>(bateria.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/camion/{id}")
    public List<BateriasModels> findByCamionesModelId(@PathVariable Long id) {
        return bateriaService.findByCamionesModelId(id);
    }

    @GetMapping("/promedios/{camionId}")
    public BateriaStatsResponse getBateriaStatsByCamionId(@PathVariable Long camionId) {
        return bateriaService.getBateriaStatsByCamionId(camionId);
    }
    /** **/




    @GetMapping("/bateriaxemp/{id}")
    public List<BateriasModels> buscarBateriasPorCamionesModel2(@PathVariable Long id) {
        EmpresasModel empresasModel = new EmpresasModel();
        empresasModel.setId(id);
        return bateriaService.ListarBateriaxEmp(empresasModel);
    }
    @GetMapping("/bateriaxempest/{estado}/{id}")
    public List<BateriasModels> buscarBateriasPorCamionesModel3(@PathVariable Long id, @PathVariable Boolean estado) {
        EmpresasModel empresasModel = new EmpresasModel();
        empresasModel.setId(id);
        return bateriaService.ListarBateriaxEmpEst(empresasModel, estado);
    }

    @PostMapping
    public ResponseEntity<BateriasModels> CCam(@RequestBody BateriasModels bateriasModels){
        BateriasModels cbateria = bateriaService.CrearBateria(bateriasModels);
        return new ResponseEntity<>(cbateria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BateriasModels> ECam(@RequestBody BateriasModels bateriasModels, @PathVariable Long id){
        BateriasModels ebateria = bateriaService.EditarBateria(bateriasModels, id);
        if (ebateria != null) {
            return new ResponseEntity<>(ebateria, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("estado-bateria")
    public ResponseEntity<BateriasModels> EstadoBaterias(@RequestBody BateriasModels bateriasModels){
        BateriasModels ebateria = bateriaService.EstadosBateria(bateriasModels);
        if (ebateria != null) {
            return new ResponseEntity<>(ebateria, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BateriasModels> DCam(@PathVariable Long id){
        bateriaService.EliminarBateria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/deshabilitar/{id}")
    public ResponseEntity<BateriasModels> DeshabilitarBat(@PathVariable Long id, @RequestBody BateriasModels bateriasModels){
        BateriasModels ebateria = bateriaService.DeshabilitarBateria(bateriasModels, id);
        if(ebateria != null){
            return new ResponseEntity<>(ebateria, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
