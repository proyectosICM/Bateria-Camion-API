package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import com.api.BateriaCaminonMinero.Services.TrabajadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/trabajadores")
public class TrabajadoresController {
    @Autowired
    TrabajadoresService trabajadoresService;

    @GetMapping
    public List<TrabajadoresModel> GetAllT(){
        return trabajadoresService.ListarTrabajadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabajadoresModel> GetTById(@PathVariable Long id){
        Optional<TrabajadoresModel> trabajador = trabajadoresService.ListarTrabajadorId(id);
        if (trabajador.isPresent()){
            return new ResponseEntity<>(trabajador.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TrabajadoresModel> CrearT(@RequestBody TrabajadoresModel trabajadoresModel){
        TrabajadoresModel ttrabajador = trabajadoresService.CrearTrabajador(trabajadoresModel);
        return new ResponseEntity<>(ttrabajador, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabajadoresModel> EditarT(@RequestBody TrabajadoresModel trabajadoresModel, @PathVariable Long id){
        TrabajadoresModel etrabajador = trabajadoresService.EditarTrabajador(trabajadoresModel, id);
        if (etrabajador!=null){
            return new ResponseEntity<>(etrabajador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrabajadoresModel> EliminarT(@PathVariable Long id){
        trabajadoresService.EliminarTrabajador(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
