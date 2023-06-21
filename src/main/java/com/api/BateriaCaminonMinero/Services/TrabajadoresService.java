package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import com.api.BateriaCaminonMinero.Repositories.TrabajadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadoresService {
    @Autowired
    TrabajadoresRepository trabajadoresRepository;

    public List<TrabajadoresModel> ListarTrabajadores(){
        return trabajadoresRepository.findAll();
    }

    public Optional<TrabajadoresModel> ListarTrabajadorId(Long id){
        return trabajadoresRepository.findById(id);
    }

    public TrabajadoresModel CrearTrabajador(TrabajadoresModel trabajadoresModel){
        return trabajadoresRepository.save(trabajadoresModel);
    }

    public TrabajadoresModel EditarTrabajador(TrabajadoresModel trabajadoresModel, Long id){
        Optional<TrabajadoresModel> existing = trabajadoresRepository.findById(id);
        if(existing.isPresent()){
            TrabajadoresModel trabajadores = existing.get();
            trabajadores.setNom_tra(trabajadoresModel.getNom_tra());
            trabajadores.setApe_tra(trabajadoresModel.getApe_tra());
            trabajadores.setDni_tra(trabajadores.getDni_tra());
            trabajadores.setEst_tra(trabajadoresModel.getEst_tra());
            //trabajadores.setUsuariosModel(trabajadoresModel.getUsuariosModel());
            trabajadores.setEmpresasModel(trabajadoresModel.getEmpresasModel());
            return trabajadoresRepository.save(trabajadores);
        } else {
            return null;
        }
    }

    public void EliminarTrabajador(Long id){
        trabajadoresRepository.deleteById(id);
    }
}
