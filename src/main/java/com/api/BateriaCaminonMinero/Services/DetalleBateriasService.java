package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.BateriasModels;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.DetalleBateriasModel;
import com.api.BateriaCaminonMinero.Repositories.DetalleBateriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DetalleBateriasService {
    @Autowired
    DetalleBateriasRepository detalleBateriasRepository;

    public List<DetalleBateriasModel> ListarBateriaxDetalle(Long id){
        BateriasModels bateriasModels = new BateriasModels();
        bateriasModels.setId_bat(id);
        return detalleBateriasRepository.findByBateriasModels(bateriasModels);
    }
}
