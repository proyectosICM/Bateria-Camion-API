package com.api.BateriaCaminonMinero.controllers;

import com.api.BateriaCaminonMinero.models.EmpresasModel;
import com.api.BateriaCaminonMinero.services.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/empresas")
public class EmpresasController {
    @Autowired
    EmpresasService empresasService;

    @GetMapping
    public List<EmpresasModel> GetAllE(){
        return empresasService.ListarEmpresas();
    }
    @GetMapping("/empresasH/{est}")
    public List<EmpresasModel> ListarEmpresasH(@PathVariable("est") boolean est){
        return empresasService.ListarEmpresasH(est);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpresasModel> GetByIdE(@PathVariable Long id){
        Optional<EmpresasModel> empresa = empresasService.ListarEmpresaId(id);
        if (empresa.isPresent()){
            return new ResponseEntity<>(empresa.get(), HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<EmpresasModel> CrearE(@RequestBody EmpresasModel empresasModel){
        EmpresasModel cempresa = empresasService.CrearEmpresa(empresasModel);
        return new ResponseEntity<>(cempresa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresasModel> EditarE(@RequestBody EmpresasModel empresasModel, @PathVariable Long id){
        EmpresasModel eempresa = empresasService.EditarEmpresa(empresasModel, id);
        if (eempresa!=null){
            return new ResponseEntity<>(eempresa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpresasModel> EliminarE(@PathVariable Long id){
        empresasService.EliminarEmpresa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
