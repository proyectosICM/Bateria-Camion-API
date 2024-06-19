package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
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
