package com.api.BateriaCaminonMinero.repositories;

import com.api.BateriaCaminonMinero.models.CamionesModel;
import com.api.BateriaCaminonMinero.models.EmpresasModel;
import com.api.BateriaCaminonMinero.models.TrabajadoresModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CamionesRepository extends JpaRepository<CamionesModel, Long> {

    Optional<CamionesModel> findByTrabajadoresModel(TrabajadoresModel trabajadoresModel);

    List<CamionesModel> findByEmpresasModelAndEstado(EmpresasModel empresasModel, Boolean estado);


    /** Reformulado **/
    List<CamionesModel> findByEmpresasModelId(Long empresaId);
    Page<CamionesModel> findByEmpresasModelId(Long empresaId, Pageable pageable);
}
