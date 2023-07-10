package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.ArranquesModel;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Repositories.ArranquesRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArranquesService {
    @Autowired
    ArranquesRepositories arranqueRepositories;
    public List<ArranquesModel> ListarArranques(){
        return arranqueRepositories.findAll();
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
}
