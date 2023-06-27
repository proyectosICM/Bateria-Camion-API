package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.BateriasModels;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BateriaRepositoriy extends JpaRepository<BateriasModels, Long> {
    List<BateriasModels> findByCamionesModel(CamionesModel camionesModel);
    List<BateriasModels> findByEmpresasModel(EmpresasModel empresasModel);
}
