package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.IncidenciasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidenciasRepository extends JpaRepository<IncidenciasModel, Long> {
    List<IncidenciasModel> findByCamionesModel(CamionesModel camionesModel);
    List<IncidenciasModel> findByEmpresasModel(EmpresasModel empresasModel);
}
