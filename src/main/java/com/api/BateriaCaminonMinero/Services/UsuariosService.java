package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.UsuariosModel;
import com.api.BateriaCaminonMinero.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuariosModel> ListarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<UsuariosModel> ListarUsuarioId(Long id){
        return usuarioRepository.findById(id);
    }

    public UsuariosModel CrearUsuario(UsuariosModel usuariosModel){
        return usuarioRepository.save(usuariosModel);
    }

    public UsuariosModel EditarUsuario(UsuariosModel usuariosModel, Long id){
        Optional<UsuariosModel> existing = usuarioRepository.findById(id);
        if(existing.isPresent()){
            UsuariosModel usuario = existing.get();
            usuario.setUser_usu(usuariosModel.getUser_usu());
            usuario.setPass_usu(usuario.getPass_usu());
            usuario.setEst_usu(usuario.getEst_usu());
            usuario.setRolesModel(usuariosModel.getRolesModel());
            return usuarioRepository.save(usuario);
        } else {
            return null;
        }
    }

    public void EliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
