package com.api.BateriaCaminonMinero.services;

import com.api.BateriaCaminonMinero.dto.BateriaStatsResponse;
import com.api.BateriaCaminonMinero.models.BateriasModel;
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

    public Optional<BateriasModel> findByNombre(String nombre) {
        return bateriaRepositoriy.findByNombre(nombre);
    }

    public List<BateriasModel> findAll(){
        return bateriaRepositoriy.findAll();
    }

    public Optional<BateriasModel> findById(Long id){
        return bateriaRepositoriy.findById(id);
    }

    public List<BateriasModel> findByCamionesModelId(Long camionId) {
        return bateriaRepositoriy.findByCamionesModelId(camionId);
    }

    public List<BateriasModel> findByEmpresasModelId(Long empresaId){
        return bateriaRepositoriy.findByEmpresasModelId(empresaId);
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



    public List<BateriasModel> ListarBateriaxEmpEst(EmpresasModel empresasModel, Boolean estado){
        return bateriaRepositoriy.findByEmpresasModelAndEstado(empresasModel, estado);
    }



    public BateriasModel CrearBateria(BateriasModel bateriasModel){
        return bateriaRepositoriy.save(bateriasModel);
    }

    public BateriasModel EditarBateria(BateriasModel bateriasModel, Long id){
        Optional<BateriasModel> existing = bateriaRepositoriy.findById(id);
        if(existing.isPresent()){
            BateriasModel bateria = existing.get();
            bateria.setNombre(bateriasModel.getNombre());
            bateria.setEstado(bateriasModel.getEstado());
            bateria.setCamionesModel(bateriasModel.getCamionesModel());
            bateria.setVoltaje(bateriasModel.getVoltaje());
            bateria.setCarga(bateriasModel.getCarga());
            bateria.setCorriente(bateriasModel.getCorriente());
            bateria.setTemperatura(bateriasModel.getTemperatura());
            return bateriaRepositoriy.save(bateria);
        }
        return null;
    }

    public BateriasModel EstadosBateria(BateriasModel bateriasModel){
        Optional<BateriasModel> existing = bateriaRepositoriy.findById(bateriasModel.getId());
        if (existing.isPresent()){
            BateriasModel bateria = existing.get();
            bateria.setVoltaje(bateriasModel.getVoltaje());
            bateria.setCarga(bateriasModel.getCarga());
            bateria.setCorriente(bateriasModel.getCorriente());
            bateria.setTemperatura(bateriasModel.getTemperatura());
            return bateriaRepositoriy.save(bateria);
        }
        return null;
    }

    public void EliminarBateria(Long id){
        bateriaRepositoriy.deleteById(id);
    }

    public BateriasModel DeshabilitarBateria(BateriasModel bateriasModel, Long id){
        Optional<BateriasModel> existing = bateriaRepositoriy.findById(id);
        if (existing.isPresent()){
            BateriasModel bateria = existing.get();
            bateria.setEstado(false);
            bateria.setCamionesModel(null);
            return bateriaRepositoriy.save(bateria);
        }
        return null;
    }

}
