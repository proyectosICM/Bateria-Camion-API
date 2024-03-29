package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.BateriasModels;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Services.BateriaService;
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
    public List<BateriasModels> Getall(){
        return bateriaService.ListarBaterias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BateriasModels> GetById(@PathVariable Long id){
        Optional<BateriasModels> bateria = bateriaService.ListarBateriaId(id);
        if (bateria.isPresent()){
            return new ResponseEntity<>(bateria.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/camiones/{id}")
    public List<BateriasModels> buscarBateriasPorCamionesModel(@PathVariable Long id) {
        CamionesModel camionesModel = new CamionesModel();
        camionesModel.setId(id);
        return bateriaService.buscarBateriasPorCamionesModel(camionesModel);
    }

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
