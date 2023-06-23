package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.BateriasModels;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Repositories.BateriaRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BateriaService {
    @Autowired
    BateriaRepositoriy bateriaRepositoriy;

    public List<BateriasModels> buscarBateriasPorCamionesModel(CamionesModel camionesModel) {
        return bateriaRepositoriy.findByCamionesModel(camionesModel);
    }
}
