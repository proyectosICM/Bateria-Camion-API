package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.ArranquesModel;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArranquesRepositories extends JpaRepository<ArranquesModel, Long> {
    List<ArranquesModel> findByCamionesModel(CamionesModel camionesModel);
    List<ArranquesModel> findByEmpresasModelAndCamionesModel(EmpresasModel empresasModel, CamionesModel camionesModel);
}
