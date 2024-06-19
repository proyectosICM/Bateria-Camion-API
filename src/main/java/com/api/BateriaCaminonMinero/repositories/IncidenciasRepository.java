package com.api.BateriaCaminonMinero.repositories;

import com.api.BateriaCaminonMinero.models.CamionesModel;
import com.api.BateriaCaminonMinero.models.EmpresasModel;
import com.api.BateriaCaminonMinero.models.IncidenciasModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidenciasRepository extends JpaRepository<IncidenciasModel, Long> {
    List<IncidenciasModel> findByCamionesModelId(Long camionId);
    @Query("SELECT i FROM IncidenciasModel i WHERE i.camionesModel.id = :camionId ORDER BY i.dia DESC, i.hora DESC")
    Page<IncidenciasModel> findByCamionesModelIdOrdered(@Param("camionId") Long camionId, Pageable pageable);

    @Query("SELECT i FROM IncidenciasModel i WHERE i.empresasModel.id = :empresaId ORDER BY i.dia DESC, i.hora DESC")
    List<IncidenciasModel> findByEmpresasModelIdOrdered(@Param("empresaId") Long empresaId);

    @Query("SELECT i FROM IncidenciasModel i WHERE i.empresasModel.id = :empresaId ORDER BY i.dia DESC, i.hora DESC")
    Page<IncidenciasModel> findByEmpresasModelIdOrdered(@Param("empresaId") Long empresaId, Pageable pageable);

    /** **/

    List<IncidenciasModel> findByEmpresasModelAndEstado(EmpresasModel empresasModel, Boolean estado);
    List<IncidenciasModel> findByCamionesModelAndEstado(CamionesModel camionesModel, Boolean estado);
}
