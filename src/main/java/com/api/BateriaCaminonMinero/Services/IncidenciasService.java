package com.api.BateriaCaminonMinero.Services;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.IncidenciasModel;
import com.api.BateriaCaminonMinero.Repositories.IncidenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidenciasService {
    @Autowired
    IncidenciasRepository incidenciasRepository;

    public List<IncidenciasModel> ListarIncidencias(){
        return incidenciasRepository.findAll();
    }

    public Optional<IncidenciasModel> ListarIncidenciaId(Long id){
        return incidenciasRepository.findById(id);
    }

    public List<IncidenciasModel> ListarIncidenciasxCamion(CamionesModel camionesModel){
        return incidenciasRepository.findByCamionesModel(camionesModel);
    }

    public List<IncidenciasModel> ListarIncxCamEst(CamionesModel camionesModel, Boolean estado){
        return incidenciasRepository.findByCamionesModelAndEstado(camionesModel, estado);
    }

    public List<IncidenciasModel>ListarIncidenciasxEmpresa(EmpresasModel empresasModel){
        return incidenciasRepository.findByEmpresasModel(empresasModel);
    }

    public List<IncidenciasModel>ListarIncxEmpEst(EmpresasModel empresasModel, Boolean estado){
        return incidenciasRepository.findByEmpresasModelAndEstado(empresasModel, estado);
    }

    public IncidenciasModel CrearIncidencia(IncidenciasModel incidenciasModel){
        return incidenciasRepository.save(incidenciasModel);
    }

    public IncidenciasModel CambiarEstado(IncidenciasModel incidenciasModel, Long id){
        Optional<IncidenciasModel> existing = incidenciasRepository.findById(id);
        if (existing.isPresent()){
            IncidenciasModel incidencia = existing.get();
            incidencia.setEstado(incidenciasModel.getEstado());
            incidencia.setPrioridad(incidenciasModel.getPrioridad());
            incidencia.setRevisadoBy(incidenciasModel.getRevisadoBy());
            return incidenciasRepository.save(incidencia);
        }
        return null;
    }

    public IncidenciasModel RevisadoPor(IncidenciasModel incidenciasModel, Long id){
        Optional<IncidenciasModel> existing = incidenciasRepository.findById(id);
        if(existing.isPresent()){
            IncidenciasModel incidencias = existing.get();
            incidencias.setRevisadoBy(incidenciasModel.getRevisadoBy());
            return incidenciasRepository.save(incidencias);
        }
        return null;
    }
}
