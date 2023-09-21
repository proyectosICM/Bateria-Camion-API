package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CamionesRepository extends JpaRepository<CamionesModel, Long> {
    //Listar de camion asociado a un conductor
    Optional<CamionesModel> findByTrabajadoresModel(TrabajadoresModel trabajadoresModel);

    List<CamionesModel> findByEmpresasModelAndEstado(EmpresasModel empresasModel, Boolean estado);
    List<CamionesModel> findByEmpresasModel(EmpresasModel empresasModel);

}
