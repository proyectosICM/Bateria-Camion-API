package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Repositories.CaminonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamionesService {
    @Autowired
    CaminonesRepository caminonesRepository;

    public List<CamionesModel> ListarCamiones(){
        return caminonesRepository.findAll();
    }
}
