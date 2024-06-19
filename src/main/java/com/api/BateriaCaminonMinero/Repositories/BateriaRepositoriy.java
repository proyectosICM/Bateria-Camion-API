package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.BateriasModels;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BateriaRepositoriy extends JpaRepository<BateriasModels, Long> {
    List<BateriasModels> findByCamionesModelId(Long camionId);

    /** **/

    List<BateriasModels> findByEmpresasModel(EmpresasModel empresasModel);
    List<BateriasModels> findByEmpresasModelAndEstado(EmpresasModel empresasModel, Boolean estado);
}
