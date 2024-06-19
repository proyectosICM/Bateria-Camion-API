package com.api.BateriaCaminonMinero.repositories;

import com.api.BateriaCaminonMinero.dto.BateriaStatsResponse;
import com.api.BateriaCaminonMinero.models.BateriasModels;
import com.api.BateriaCaminonMinero.models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BateriaRepositoriy extends JpaRepository<BateriasModels, Long> {
    List<BateriasModels> findByCamionesModelId(Long camionId);

    @Query("SELECT " +
            "   b.camionesModel.id AS idCamion, " +
            "   AVG(b.voltaje) AS voltajeAVG, " +
            "   AVG(b.carga) AS cargaAVG, " +
            "   AVG(b.corriente) AS corrienteAVG " +
            "FROM BateriasModels b " +
            "WHERE b.camionesModel.id = :camionId " +
            "GROUP BY b.camionesModel.id")
    List<Map<String, Object>> getBateriaStatsByCamionId(@Param("camionId") Long camionId);

    /** **/

    List<BateriasModels> findByEmpresasModel(EmpresasModel empresasModel);
    List<BateriasModels> findByEmpresasModelAndEstado(EmpresasModel empresasModel, Boolean estado);
}
