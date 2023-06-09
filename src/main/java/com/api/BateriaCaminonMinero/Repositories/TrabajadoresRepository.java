package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import com.api.BateriaCaminonMinero.Models.RolesModel;
import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TrabajadoresRepository extends JpaRepository<TrabajadoresModel, Long> {

    Optional<TrabajadoresModel> findByUsername(String username);
    List<TrabajadoresModel> findByEmpresasModelAndRolesModel(EmpresasModel empresasModel, RolesModel rolesModel);

    List<TrabajadoresModel> findByEmpresasModel(EmpresasModel empresasModel);

    List<TrabajadoresModel> findByEstadoAndEmpresasModel(Boolean estado, EmpresasModel empresasModel);
}
