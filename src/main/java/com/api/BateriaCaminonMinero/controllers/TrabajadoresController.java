package com.api.BateriaCaminonMinero.controllers;

import com.api.BateriaCaminonMinero.models.EmpresasModel;
import com.api.BateriaCaminonMinero.models.RolesModel;
import com.api.BateriaCaminonMinero.models.TrabajadoresModel;
import com.api.BateriaCaminonMinero.repositories.EmpresasRepository;
import com.api.BateriaCaminonMinero.repositories.RolesRepository;
import com.api.BateriaCaminonMinero.repositories.TrabajadoresRepository;
import com.api.BateriaCaminonMinero.request.CreateUserDTO;
import com.api.BateriaCaminonMinero.services.TrabajadoresService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/trabajadores")
public class TrabajadoresController {
    @Autowired
    TrabajadoresService trabajadoresService;

    @Autowired
    RolesRepository rolesRepository;
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

    @GetMapping("/conductores/{empresa}")
    public List<TrabajadoresModel> Conductores(@PathVariable("empresa") Long empresa){
        List<TrabajadoresModel> trabajadores = trabajadoresService.ListarConductores(empresa);
        return trabajadores;
    }

    @PostMapping
    public ResponseEntity<TrabajadoresModel> CrearT(@RequestBody TrabajadoresModel trabajadoresModel){
        TrabajadoresModel ttrabajador = trabajadoresService.CrearTrabajador(trabajadoresModel);
        return new ResponseEntity<>(ttrabajador, HttpStatus.CREATED);
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){
        Long empresaId = createUserDTO.getEmpresaId();

        EmpresasModel empresa = empresasRepository.findById(empresaId)
                .orElseThrow(() -> new EntityNotFoundException("Empresa no encontrada"));

        Long rolId = createUserDTO.getRoles();
        RolesModel rol = rolesRepository.findById(rolId)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));

        /*Set<String> rolesNames = createUserDTO.getRoles();
        Set<RolesModel> roles = rolesNames.stream()
                .map(roleName -> rolesRepository.findByName(ERole.valueOf(roleName))
                        .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado: " + roleName)))
                .collect(Collectors.toSet());
*/
        TrabajadoresModel trabajadoresModel = TrabajadoresModel.builder()
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPass_tra()))
                .nombre(createUserDTO.getNom_tra())
                .apellido(createUserDTO.getApe_tra())
                .dni(createUserDTO.getDni_tra())
                .estado(createUserDTO.getEstado())
                .rolesModel(rol)
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
