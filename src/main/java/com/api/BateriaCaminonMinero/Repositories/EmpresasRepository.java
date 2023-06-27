package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresasRepository extends JpaRepository<EmpresasModel, Long> {
    @Query(value = "CALL EMPRESASH(:est)", nativeQuery = true)
    List<Object[]> ListarEmpresasH(@Param("est") boolean est);
}
