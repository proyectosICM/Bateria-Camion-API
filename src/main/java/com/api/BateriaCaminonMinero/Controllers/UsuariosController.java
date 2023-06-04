package com.api.BateriaCaminonMinero.Controllers;

import com.api.BateriaCaminonMinero.Models.UsuariosModel;
import com.api.BateriaCaminonMinero.Repositories.UsuarioRepository;
import com.api.BateriaCaminonMinero.Services.UsuariosService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {
    @Autowired
    UsuariosService usuariosService;

    @GetMapping
    public List<UsuariosModel> GetAllU(){
        return usuariosService.ListarUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosModel> GetByIdU(@PathVariable Long id){
        Optional<UsuariosModel> usuarios = usuariosService.ListarUsuarioId(id);
        if (usuarios.isPresent()){
            return new ResponseEntity<>(usuarios.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UsuariosModel> CrearU(@RequestBody UsuariosModel usuariosModel){
        UsuariosModel cusuario = usuariosService.CrearUsuario(usuariosModel);
        return new ResponseEntity<>(cusuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuariosModel> EditarU(@RequestBody UsuariosModel usuariosModel, @PathVariable Long id){
           UsuariosModel eusuario = usuariosService.EditarUsuario(usuariosModel, id);
           if(eusuario!=null){
               return new ResponseEntity<>(eusuario, HttpStatus.OK);
           } else {
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuariosModel> EliminarE(@PathVariable Long id){
        usuariosService.EliminarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
