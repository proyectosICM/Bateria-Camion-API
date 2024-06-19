package com.api.BateriaCaminonMinero.services;

import com.api.BateriaCaminonMinero.models.CamionesModel;
import com.api.BateriaCaminonMinero.models.EmpresasModel;
import com.api.BateriaCaminonMinero.models.IncidenciasModel;
import com.api.BateriaCaminonMinero.repositories.IncidenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidenciasService {
    @Autowired
    IncidenciasRepository incidenciasRepository;

    public List<IncidenciasModel> findAll(){
        return incidenciasRepository.findAll();
    }

    public Optional<IncidenciasModel> findById(Long id){
        return incidenciasRepository.findById(id);
    }

    public List<IncidenciasModel> findByCamionesModelId(Long camionId){
        return incidenciasRepository.findByCamionesModelId(camionId);
    }

    public Page<IncidenciasModel> findByCamionesModelIdOrdered(Long camionId, Pageable pageable){
        return incidenciasRepository.findByCamionesModelIdOrdered(camionId, pageable);
    }

    public List<IncidenciasModel>findByEmpresasModelIdOrdered(Long empresaId){
        return incidenciasRepository.findByEmpresasModelIdOrdered(empresaId);
    }

    public Page<IncidenciasModel> findByEmpresasModelIdOrdered(Long empresaId, Pageable pageable){
        return incidenciasRepository.findByEmpresasModelIdOrdered(empresaId, pageable);
    }

    /** **/

    public List<IncidenciasModel> ListarIncxCamEst(CamionesModel camionesModel, Boolean estado){
        return incidenciasRepository.findByCamionesModelAndEstado(camionesModel, estado);
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
