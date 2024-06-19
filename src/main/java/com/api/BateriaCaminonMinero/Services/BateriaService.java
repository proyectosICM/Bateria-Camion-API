package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.BateriasModels;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Repositories.BateriaRepositoriy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
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
