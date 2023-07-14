package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.ArranquesModel;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Repositories.ArranquesRepositories;
import com.api.BateriaCaminonMinero.Repositories.CamionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArranquesService {
    @Autowired
    ArranquesRepositories arranqueRepositories;

    @Autowired
    CamionesRepository camionesRepository;
    public List<ArranquesModel> ListarArranques(){
        return arranqueRepositories.findAll();
    }
    public List<ArranquesModel> ArranqueUltimoDia(int camion){
        return arranqueRepositories.ArranqueUltimoDia(camion);
    }

    public List<Object[]> obtenerPromedioCorrienteUltimoMes(int camion) {
        return arranqueRepositories.PromedioCorrienteUltimoMes(camion);
    }
    public List<Object[]> PromedioCamion(int camion){
        return arranqueRepositories.PromediosxCamion(camion);
    }

    public List<Object[]> ConteoRegistrosYear(int camion){
        return arranqueRepositories.ConteoDeRegistrosxYears(camion);
    }

    public List<ArranquesModel> ListarArranquexCamion(Long id){
        CamionesModel camionesModel = new CamionesModel();
        camionesModel.setId_cam(id);
        return arranqueRepositories.findByCamionesModel(camionesModel);
    }

    public List<ArranquesModel> ListarArranqueXEmpresaYxCamion(Long empresa, Long camion){
        EmpresasModel empresasModel = new EmpresasModel();
        empresasModel.setId_emp(empresa);

        CamionesModel camionesModel = new CamionesModel();
        camionesModel.setId_cam(camion);

        return arranqueRepositories.findByEmpresasModelAndCamionesModel(empresasModel, camionesModel);
    }

    public ArranquesModel RegistrarArranqueSecond(ArranquesModel arranquesModel, Long id){
        Optional<CamionesModel> camionesModel = camionesRepository.findById(id);
        if (camionesModel.isPresent()) {
            CamionesModel camion = camionesModel.get();
            if (arranquesModel.getCamionesModel() == null) {
                arranquesModel.setCamionesModel(new CamionesModel()); // Inicializar si es null
            }
            arranquesModel.getCamionesModel().setId_cam(camion.getId_cam());

            if (arranquesModel.getEmpresasModel() == null) {
                arranquesModel.setEmpresasModel(new EmpresasModel()); // Inicializar si es null
            }
            arranquesModel.getEmpresasModel().setId_emp(camion.getEmpresasModel().getId_emp());

            if (arranquesModel.getCorriente() > camion.getCorrienteArranque()) {
                return arranqueRepositories.save(arranquesModel);
            }
        }
        return null;
    }

    public ArranquesModel RegistrarArranque(ArranquesModel arranquesModel){
        if (arranquesModel.getCorriente() > arranquesModel.getCamionesModel().getCorrienteArranque()){
            return arranqueRepositories.save(arranquesModel);
        }
        return null;
    }

    public ArranquesModel Registar(ArranquesModel arranquesModel){
        return arranqueRepositories.save(arranquesModel);
    }
}
