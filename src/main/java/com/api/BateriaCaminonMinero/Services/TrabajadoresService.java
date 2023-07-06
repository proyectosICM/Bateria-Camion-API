package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.ERole;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.RolesModel;
import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import com.api.BateriaCaminonMinero.Repositories.TrabajadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
        empresasModel.setId_emp(id);
        return trabajadoresRepository.findByEmpresasModel(empresasModel);
    }

    public List<TrabajadoresModel> ListarTrabjadorxEmpH(Boolean estado, Long id){
        EmpresasModel empresasModel = new EmpresasModel();
        empresasModel.setId_emp(id);
        return trabajadoresRepository.findByEstadoAndEmpresasModel(estado, empresasModel);
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
            trabajadores.setNom_tra(trabajadoresModel.getNom_tra());
            trabajadores.setApe_tra(trabajadoresModel.getApe_tra());
            trabajadores.setDni_tra(trabajadoresModel.getDni_tra());
            trabajadores.setUsername(trabajadoresModel.getUsername());
            trabajadores.setPass_tra(passwordEncoder.encode(trabajadoresModel.getPass_tra()));
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
