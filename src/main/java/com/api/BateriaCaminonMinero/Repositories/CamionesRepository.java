package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CamionesRepository extends JpaRepository<CamionesModel, Long> {
    List<CamionesModel> findByEmpresasModelAndEstado(EmpresasModel empresasModel, Boolean estado);
    List<CamionesModel> findByEmpresasModel(EmpresasModel empresasModel);
}
