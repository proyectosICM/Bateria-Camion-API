package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.BateriasModels;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Repositories.BateriaRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BateriaService {
    @Autowired
    BateriaRepositoriy bateriaRepositoriy;

    public List<BateriasModels> buscarBateriasPorCamionesModel(CamionesModel camionesModel) {
        return bateriaRepositoriy.findByCamionesModel(camionesModel);
    }
/*
    public List<BateriasModels> ListarBateriaxEmp(EmpresasModel empresasModel){
        return bateriaRepositoriy.findByEmpresasModel(empresasModel);
    }*/
    public List<BateriasModels> ListarBaterias(){
        return bateriaRepositoriy.findAll();
    }

    public Optional<BateriasModels> ListarBateriaId(Long id){
        return bateriaRepositoriy.findById(id);
    }

    public BateriasModels CrearBateria(BateriasModels bateriasModels){
        return bateriaRepositoriy.save(bateriasModels);
    }

    public BateriasModels EditarBateria(BateriasModels bateriasModels, Long id){
        Optional<BateriasModels> existing = bateriaRepositoriy.findById(id);
        if(existing.isPresent()){
            BateriasModels bateria = existing.get();
            bateria.setNom_bat(bateriasModels.getNom_bat());
            bateria.setEst_bat(bateriasModels.getEst_bat());
            bateria.setCamionesModel(bateriasModels.getCamionesModel());
            bateria.setVoltaje(bateriasModels.getVoltaje());
            bateria.setCarga(bateriasModels.getCarga());
            bateria.setCorriente(bateriasModels.getCorriente());
            bateria.setTemperatura(bateriasModels.getTemperatura());
            return bateriaRepositoriy.save(bateria);
        }
        return null;
    }

    public void EliminarBateria(Long id){
        bateriaRepositoriy.deleteById(id);
    }

}
