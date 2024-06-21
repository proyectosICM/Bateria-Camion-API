package com.api.BateriaCaminonMinero.controllers;

import com.api.BateriaCaminonMinero.dto.BateriaStatsResponse;
import com.api.BateriaCaminonMinero.models.BateriasModel;
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

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<BateriasModel> findByNombre(@PathVariable String nombre){
        Optional<BateriasModel> bateria = bateriaService.findByNombre(nombre);
        if (bateria.isPresent()){
            return new ResponseEntity<>(bateria.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<BateriasModel> findAll(){
        return bateriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BateriasModel> findById(@PathVariable Long id){
        Optional<BateriasModel> bateria = bateriaService.findById(id);
        if (bateria.isPresent()){
            return new ResponseEntity<>(bateria.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/camion/{id}")
    public List<BateriasModel> findByCamionesModelId(@PathVariable Long id) {
        return bateriaService.findByCamionesModelId(id);
    }

    @GetMapping("/empresa/{id}")
    public List<BateriasModel> findByEmpresasModelId(@PathVariable Long id) {
        return bateriaService.findByEmpresasModelId(id);
    }

    @GetMapping("/promedios/{camionId}")
    public BateriaStatsResponse getBateriaStatsByCamionId(@PathVariable Long camionId) {
        return bateriaService.getBateriaStatsByCamionId(camionId);
    }
    /** **/





    @GetMapping("/bateriaxempest/{estado}/{id}")
    public List<BateriasModel> buscarBateriasPorCamionesModel3(@PathVariable Long id, @PathVariable Boolean estado) {
        EmpresasModel empresasModel = new EmpresasModel();
        empresasModel.setId(id);
        return bateriaService.ListarBateriaxEmpEst(empresasModel, estado);
    }

    @PostMapping
    public ResponseEntity<BateriasModel> CCam(@RequestBody BateriasModel bateriasModel){
        BateriasModel cbateria = bateriaService.CrearBateria(bateriasModel);
        return new ResponseEntity<>(cbateria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BateriasModel> ECam(@RequestBody BateriasModel bateriasModel, @PathVariable Long id){
        BateriasModel ebateria = bateriaService.EditarBateria(bateriasModel, id);
        if (ebateria != null) {
            return new ResponseEntity<>(ebateria, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("estado-bateria")
    public ResponseEntity<BateriasModel> EstadoBaterias(@RequestBody BateriasModel bateriasModel){
        BateriasModel ebateria = bateriaService.EstadosBateria(bateriasModel);
        if (ebateria != null) {
            return new ResponseEntity<>(ebateria, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BateriasModel> DCam(@PathVariable Long id){
        bateriaService.EliminarBateria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/deshabilitar/{id}")
    public ResponseEntity<BateriasModel> DeshabilitarBat(@PathVariable Long id, @RequestBody BateriasModel bateriasModel){
        BateriasModel ebateria = bateriaService.DeshabilitarBateria(bateriasModel, id);
        if(ebateria != null){
            return new ResponseEntity<>(ebateria, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
