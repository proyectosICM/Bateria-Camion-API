package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.ERole;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.RolesModel;
import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import com.api.BateriaCaminonMinero.Repositories.EmpresasRepository;
import com.api.BateriaCaminonMinero.Repositories.TrabajadoresRepository;
import com.api.BateriaCaminonMinero.Request.CreateUserDTO;
import com.api.BateriaCaminonMinero.Services.TrabajadoresService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/trabajadores")
public class TrabajadoresController {
    @Autowired
    TrabajadoresService trabajadoresService;
   @Autowired
   PasswordEncoder passwordEncoder;

    @Autowired
    TrabajadoresRepository trabajadoresRepository;
    @Autowired
    EmpresasRepository empresasRepository;


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
    @GetMapping("/trabajadoresxEmpT/{emp}")
    public List<TrabajadoresModel> BusesxEmpT(@PathVariable("emp") Long emp){
        return trabajadoresService.ListarTrabjadorxEmpT(emp);
    }

    @GetMapping("/trabajadoresxEmpH/{est}/{emp}")
    public List<TrabajadoresModel> BusesxEmpH(@PathVariable("est") Boolean est, @PathVariable("emp") Long emp){
        return trabajadoresService.ListarTrabjadorxEmpH(est, emp);
    }

    @GetMapping("/info/{username}")
    public ResponseEntity<TrabajadoresModel> infoTra(@PathVariable("username") String username){
        Optional<TrabajadoresModel> trabajadores = trabajadoresService.ListarInfo(username);
        if (trabajadores.isPresent()){
            return new ResponseEntity<>(trabajadores.get(), HttpStatus.OK);
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<TrabajadoresModel> CrearT(@RequestBody TrabajadoresModel trabajadoresModel){
        TrabajadoresModel ttrabajador = trabajadoresService.CrearTrabajador(trabajadoresModel);
        return new ResponseEntity<>(ttrabajador, HttpStatus.CREATED);
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody  CreateUserDTO createUserDTO){

        Set<RolesModel> roles = createUserDTO.getRoles().stream()
                .map( rol -> RolesModel.builder()
                        .name(ERole.valueOf(rol))
                        .build())
                .collect(Collectors.toSet());

        Long empresaId = createUserDTO.getEmpresaId();
        EmpresasModel empresa = empresasRepository.findById(empresaId)
                .orElseThrow(() -> new EntityNotFoundException("Empresa no encontrada"));

        TrabajadoresModel trabajadoresModel = TrabajadoresModel.builder()
                .username(createUserDTO.getUsername())
                .pass_tra(passwordEncoder.encode(createUserDTO.getPass_tra()))
                .nom_tra(createUserDTO.getNom_tra())
                .ape_tra(createUserDTO.getApe_tra())
                .dni_tra(createUserDTO.getDni_tra())
                .est_tra(createUserDTO.getEst_tra())
                .roles(roles)
                .empresasModel(empresa)
                .build();
        trabajadoresRepository.save(trabajadoresModel);
        return ResponseEntity.ok(trabajadoresModel);
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
