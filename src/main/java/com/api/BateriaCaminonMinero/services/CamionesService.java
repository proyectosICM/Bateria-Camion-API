package com.api.BateriaCaminonMinero.services;

import com.api.BateriaCaminonMinero.models.CamionesModel;
import com.api.BateriaCaminonMinero.models.EmpresasModel;
import com.api.BateriaCaminonMinero.models.TrabajadoresModel;
import com.api.BateriaCaminonMinero.repositories.CamionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamionesService {
    @Autowired
    private CamionesRepository camionesRepository;

    public List<CamionesModel> findAll(){
        return camionesRepository.findAll();
    }

    public Optional<CamionesModel> findById(Long id){
        return camionesRepository.findById(id);
    }

    public List<CamionesModel>findByEmpresasModelId(Long empresaId){
        return camionesRepository.findByEmpresasModelId(empresaId);
    }

    public Page<CamionesModel> findByEmpresasModelId(Long empresaId, Pageable pageable){
        return camionesRepository.findByEmpresasModelId(empresaId, pageable);
    }

    /* */

    public Optional<CamionesModel> ListarCamionxTrabajador(Long id){
        TrabajadoresModel trabajadoresModel = new TrabajadoresModel();
        trabajadoresModel.setId(id);
        return camionesRepository.findByTrabajadoresModel(trabajadoresModel);
    }


    public List<CamionesModel>ListarCamionesxEmpresaEst(EmpresasModel empresasModel, Boolean estado){
        return camionesRepository.findByEmpresasModelAndEstado(empresasModel, estado);
    }


    public CamionesModel CrearCamion(CamionesModel camionesModel){
        return camionesRepository.save(camionesModel);
    }

    public CamionesModel EditarCamion(CamionesModel camionesModel, Long id){
        Optional<CamionesModel> existing = camionesRepository.findById(id);
        if (existing.isPresent()){
            CamionesModel camion = existing.get();
            camion.setPlaca(camionesModel.getPlaca());
            camion.setEstado(camionesModel.getEstado());
            camion.setEmpresasModel(camionesModel.getEmpresasModel());
            camion.setTrabajadoresModel(camionesModel.getTrabajadoresModel());
            return camionesRepository.save(camion);
        } else {
            return null;
        }
    }

    public CamionesModel EditarCorrienteArranque(CamionesModel camionesModel, Long id){
        Optional<CamionesModel> existing = camionesRepository.findById(id);
        if(existing.isPresent()){
            CamionesModel camion = existing.get();
            camion.setCorrienteArranque(camionesModel.getCorrienteArranque());
            return camionesRepository.save(camion);
        }
        return null;
    }

    public void EliminarCamion(Long id){
        camionesRepository.deleteById(id);
    }
}
