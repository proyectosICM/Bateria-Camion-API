package com.api.BateriaCaminonMinero.repositories;

import com.api.BateriaCaminonMinero.models.EmpresasModel;
import com.api.BateriaCaminonMinero.models.RolesModel;
import com.api.BateriaCaminonMinero.models.TrabajadoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrabajadoresRepository extends JpaRepository<TrabajadoresModel, Long> {

    Optional<TrabajadoresModel> findByUsername(String username);
    List<TrabajadoresModel> findByEmpresasModelAndRolesModel(EmpresasModel empresasModel, RolesModel rolesModel);

    List<TrabajadoresModel> findByEmpresasModel(EmpresasModel empresasModel);

    List<TrabajadoresModel> findByEstadoAndEmpresasModel(Boolean estado, EmpresasModel empresasModel);
}
