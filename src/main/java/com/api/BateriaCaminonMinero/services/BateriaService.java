package com.api.BateriaCaminonMinero.services;

import com.api.BateriaCaminonMinero.dto.BateriaStatsResponse;
import com.api.BateriaCaminonMinero.models.BateriasModels;
import com.api.BateriaCaminonMinero.models.EmpresasModel;
import com.api.BateriaCaminonMinero.repositories.BateriaRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BateriaService {
    @Autowired
    private BateriaRepositoriy bateriaRepositoriy;

    public List<BateriasModels> findAll(){
        return bateriaRepositoriy.findAll();
    }

    public Optional<BateriasModels> findById(Long id){
        return bateriaRepositoriy.findById(id);
    }

    public List<BateriasModels> findByCamionesModelId(Long camionId) {
        return bateriaRepositoriy.findByCamionesModelId(camionId);
    }

    public BateriaStatsResponse getBateriaStatsByCamionId(Long camionId) {
        List<Map<String, Object>> resultList = bateriaRepositoriy.getBateriaStatsByCamionId(camionId);
        if (!resultList.isEmpty()) {
            Map<String, Object> resultMap = resultList.get(0); // Assuming there's only one result due to GROUP BY
            Double voltajeAVG = (Double) resultMap.get("voltajeAVG");
            Double cargaAVG = (Double) resultMap.get("cargaAVG");
            Double corrienteAVG = (Double) resultMap.get("corrienteAVG");
            Long idCamion = (Long) resultMap.get("idCamion");

            return new BateriaStatsResponse(voltajeAVG, cargaAVG, corrienteAVG, idCamion);
        }
        return null; // or handle appropriately if no results found
    }

    /** **/


    public List<BateriasModels> ListarBateriaxEmp(EmpresasModel empresasModel){
        return bateriaRepositoriy.findByEmpresasModel(empresasModel);
    }
    public List<BateriasModels> ListarBateriaxEmpEst(EmpresasModel empresasModel, Boolean estado){
        return bateriaRepositoriy.findByEmpresasModelAndEstado(empresasModel, estado);
    }



    public BateriasModels CrearBateria(BateriasModels bateriasModels){
        return bateriaRepositoriy.save(bateriasModels);
    }

    public BateriasModels EditarBateria(BateriasModels bateriasModels, Long id){
        Optional<BateriasModels> existing = bateriaRepositoriy.findById(id);
        if(existing.isPresent()){
            BateriasModels bateria = existing.get();
            bateria.setNombre(bateriasModels.getNombre());
            bateria.setEstado(bateriasModels.getEstado());
            bateria.setCamionesModel(bateriasModels.getCamionesModel());
            bateria.setVoltaje(bateriasModels.getVoltaje());
            bateria.setCarga(bateriasModels.getCarga());
            bateria.setCorriente(bateriasModels.getCorriente());
            bateria.setTemperatura(bateriasModels.getTemperatura());
            return bateriaRepositoriy.save(bateria);
        }
        return null;
    }

    public BateriasModels EstadosBateria(BateriasModels bateriasModels){
        Optional<BateriasModels> existing = bateriaRepositoriy.findById(bateriasModels.getId());
        if (existing.isPresent()){
            BateriasModels bateria = existing.get();
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

    public BateriasModels DeshabilitarBateria(BateriasModels bateriasModels, Long id){
        Optional<BateriasModels> existing = bateriaRepositoriy.findById(id);
        if (existing.isPresent()){
            BateriasModels bateria = existing.get();
            bateria.setEstado(false);
            bateria.setCamionesModel(null);
            return bateriaRepositoriy.save(bateria);
        }
        return null;
    }

}
