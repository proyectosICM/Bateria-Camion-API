package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.RolesModel;
import com.api.BateriaCaminonMinero.Repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    RolesRepository rolesRepository;

    public List<RolesModel> ListarRoles(){
        return rolesRepository.findAll();
    }

    public Optional<RolesModel> ListarRolId(Long id){
        return rolesRepository.findById(id);
    }

    public RolesModel CrearRoles(RolesModel rolesModel){
        return rolesRepository.save(rolesModel);
    }

    public RolesModel EditarRoles(RolesModel rolesModel, Long id){
        Optional<RolesModel> existing = rolesRepository.findById(id);
        if(existing.isPresent()){
            RolesModel rol = existing.get();
            rol.setNom_rol(rolesModel.getNom_rol());
            rol.setEst_rol(rolesModel.getEst_rol());
            return rolesRepository.save(rol);
        } else {
            return null;
        }
    }

    public void EliminarRoles(Long id){
        rolesRepository.deleteById(id);
    }
}
