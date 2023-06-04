package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Repositories.CamionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamionesService {
    @Autowired
    CamionesRepository camionesRepository;

    public List<CamionesModel> ListarCamiones(){
        return camionesRepository.findAll();
    }

    public Optional<CamionesModel> ListarCamionId(Long id){
        return camionesRepository.findById(id);
    }

    public CamionesModel CrearCamion(CamionesModel camionesModel){
        return camionesRepository.save(camionesModel);
    }

    public CamionesModel EditarCamion(CamionesModel camionesModel, Long id){
        Optional<CamionesModel> existing = camionesRepository.findById(id);
        if (existing.isPresent()){
            CamionesModel camion = existing.get();
            camion.setPlaca_cam(camionesModel.getPlaca_cam());
            camion.setEst_cam(camionesModel.getEst_cam());
            camion.setEmpresasModel(camionesModel.getEmpresasModel());
            camion.setTrabajadoresModel(camionesModel.getTrabajadoresModel());
            return camionesRepository.save(camion);
        } else {
            return null;
        }
    }

    public void EliminarCamion(Long id){
        camionesRepository.deleteById(id);
    }
}
