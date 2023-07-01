package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CamionesRepository extends JpaRepository<CamionesModel, Long> {
    //Listar de camion asociado a un conductor
    List<CamionesModel> findByTrabajadoresModel(TrabajadoresModel trabajadoresModel);

    List<CamionesModel> findByEmpresasModelAndEstado(EmpresasModel empresasModel, Boolean estado);
    List<CamionesModel> findByEmpresasModel(EmpresasModel empresasModel);

}
