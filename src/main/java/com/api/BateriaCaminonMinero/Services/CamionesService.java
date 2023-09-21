package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.IncidenciasModel;
import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
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
    //Listar camion asociado a un conductor
    public Optional<CamionesModel> ListarCamionxTrabajador(Long id){
        TrabajadoresModel trabajadoresModel = new TrabajadoresModel();
        trabajadoresModel.setId_tra(id);
        return camionesRepository.findByTrabajadoresModel(trabajadoresModel);
    }




    public Optional<CamionesModel> ListarCamionId(Long id){
        return camionesRepository.findById(id);
    }
    public List<CamionesModel>ListarCamionesxEmpresaEst(EmpresasModel empresasModel, Boolean estado){
        return camionesRepository.findByEmpresasModelAndEstado(empresasModel, estado);
    }

    public List<CamionesModel>ListarCamionesxEmpresa(EmpresasModel empresasModel){
        return camionesRepository.findByEmpresasModel(empresasModel);
    }


    public CamionesModel CrearCamion(CamionesModel camionesModel){
        return camionesRepository.save(camionesModel);
    }

    public CamionesModel EditarCamion(CamionesModel camionesModel, Long id){
        Optional<CamionesModel> existing = camionesRepository.findById(id);
        if (existing.isPresent()){
            CamionesModel camion = existing.get();
            camion.setPlaca_cam(camionesModel.getPlaca_cam());
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
