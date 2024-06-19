package com.api.BateriaCaminonMinero.services;

import com.api.BateriaCaminonMinero.models.EmpresasModel;
import com.api.BateriaCaminonMinero.models.RolesModel;
import com.api.BateriaCaminonMinero.models.TrabajadoresModel;
import com.api.BateriaCaminonMinero.repositories.TrabajadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TrabajadoresService {
    @Autowired
    TrabajadoresRepository trabajadoresRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    public List<TrabajadoresModel> ListarTrabajadores(){
        return trabajadoresRepository.findAll();
    }

    public Optional<TrabajadoresModel> ListarTrabajadorId(Long id){
        return trabajadoresRepository.findById(id);
    }

    public Optional<TrabajadoresModel> ListarInfo(String username){
       /* TrabajadoresModel trabajadoresModel = new TrabajadoresModel();
        trabajadoresModel.setUsername(username);*/
        return trabajadoresRepository.findByUsername(username);
    }
    public List<TrabajadoresModel> ListarTrabjadorxEmpT(Long id){
        EmpresasModel empresasModel = new EmpresasModel();
        empresasModel.setId(id);
        return trabajadoresRepository.findByEmpresasModel(empresasModel);
    }

    public List<TrabajadoresModel> ListarTrabjadorxEmpH(Boolean estado, Long id){
        EmpresasModel empresasModel = new EmpresasModel();
        empresasModel.setId(id);
        return trabajadoresRepository.findByEstadoAndEmpresasModel(estado, empresasModel);
    }

    public List<TrabajadoresModel> ListarConductores(Long empresa){
        EmpresasModel empresasModel = new EmpresasModel();
        empresasModel.setId(empresa);

        RolesModel rolesModel = new RolesModel();
        rolesModel.setId(1L);
        return trabajadoresRepository.findByEmpresasModelAndRolesModel(empresasModel, rolesModel);
    }

    public TrabajadoresModel CrearTrabajador(TrabajadoresModel trabajadoresModel){
        return trabajadoresRepository.save(trabajadoresModel);
    }

    public TrabajadoresModel EditarTrabajador(TrabajadoresModel trabajadoresModel, Long id){
        Optional<TrabajadoresModel> existing = trabajadoresRepository.findById(id);
        /*Set<RolesModel> roles = trabajadoresModel.getRoles().stream()
                .map(rol -> RolesModel.builder()
                        .name(rol.getName())
                        .build())
                .collect(Collectors.toSet());*/

        if(existing.isPresent()){
            TrabajadoresModel trabajadores = existing.get();
            trabajadores.setNombre(trabajadoresModel.getNombre());
            trabajadores.setApellido(trabajadoresModel.getApellido());
            trabajadores.setDni(trabajadoresModel.getDni());
            trabajadores.setUsername(trabajadoresModel.getUsername());
            trabajadores.setPassword(passwordEncoder.encode(trabajadoresModel.getPassword()));
            trabajadores.setEstado(trabajadoresModel.getEstado());
            trabajadores.setEmpresasModel(trabajadoresModel.getEmpresasModel());
            trabajadores.setRolesModel(trabajadoresModel.getRolesModel());
            return trabajadoresRepository.save(trabajadores);
        } else {
            return null;
        }
    }

    public void EliminarTrabajador(Long id){
        trabajadoresRepository.deleteById(id);
    }
}
