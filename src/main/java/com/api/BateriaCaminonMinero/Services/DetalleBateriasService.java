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

    public List<Object[]> getDetallesValores(int camion) {
        return detalleBateriasRepository.getDetallesValores(camion);
    }

    public List<DetalleBateriasModel> getDetallesBaterias(int camion, int detalles) {
        List<Object[]> resultados = detalleBateriasRepository.getDetallesBaterias(camion, detalles);
        List<DetalleBateriasModel> detbatList = new ArrayList<>();

        for (Object[] resultado : resultados) {
            DetalleBateriasModel detm = new DetalleBateriasModel();
            detm.setId_dc((Long) resultado[0]);
            BateriasModels bateriam = new BateriasModels();
            bateriam.setNom_bat((String) resultado[1]);
            CamionesModel camionesm = new CamionesModel();
            camionesm.setPlaca_cam((String) resultado[2]);
            bateriam.setCamionesModel(camionesm);
            detm.setBateriasModels(bateriam);
            detm.setDia((Date) resultado[3]);
            detm.setHora((Time) resultado[4]);
            detm.setVoltaje((Double) resultado[5]);
            detm.setCarga((Integer) resultado[6]);
            detm.setTemperatura((Double) resultado[7]);
            detbatList.add(detm);
        }

        return detbatList;
    }

    public List<DetalleBateriasModel> getDetallesBateriasT(int camion, int detalles) {
        List<Object[]> resultados = detalleBateriasRepository.getDetallesBateriasT(camion, detalles);
        List<DetalleBateriasModel> detbatList = new ArrayList<>();

        for (Object[] resultado : resultados) {
            DetalleBateriasModel detm = new DetalleBateriasModel();
            detm.setId_dc((Long) resultado[0]);
            BateriasModels bateriam = new BateriasModels();
            bateriam.setNom_bat((String) resultado[1]);
            CamionesModel camionesm = new CamionesModel();
            camionesm.setPlaca_cam((String) resultado[2]);
            bateriam.setCamionesModel(camionesm);
            detm.setBateriasModels(bateriam);
            detm.setDia((Date) resultado[3]);
            detm.setHora((Time) resultado[4]);
            detm.setVoltaje((Double) resultado[5]);
            detm.setCarga((Integer) resultado[6]);
            detm.setTemperatura((Double) resultado[7]);
            detbatList.add(detm);
        }

        return detbatList;
    }
}
