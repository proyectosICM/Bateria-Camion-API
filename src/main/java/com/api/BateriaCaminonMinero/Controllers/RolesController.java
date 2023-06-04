package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.RolesModel;
import com.api.BateriaCaminonMinero.Services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/roles")
public class RolesController {
    @Autowired
    RolesService rolesService;

    @GetMapping
    public List<RolesModel> GetAllR(){
        return rolesService.ListarRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesModel> GetByIdR(@PathVariable Long id){
        Optional<RolesModel> roles = rolesService.ListarRolId(id);
        if (roles.isPresent()){
            return new ResponseEntity<>(roles.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<RolesModel> CrearR(@RequestBody RolesModel rolesModel){
        RolesModel croles = rolesService.CrearRoles(rolesModel);
        return new ResponseEntity<>(croles, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesModel> EditarR(@PathVariable Long id, @RequestBody RolesModel rolesModel){
        RolesModel eroles = rolesService.EditarRoles(rolesModel, id);
        if(eroles!=null){
            return new ResponseEntity<>(eroles, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<RolesModel> EliminarR(@PathVariable Long id){
        rolesService.EliminarRoles(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
