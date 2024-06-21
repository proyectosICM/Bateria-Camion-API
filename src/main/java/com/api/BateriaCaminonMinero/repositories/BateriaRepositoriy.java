package com.api.BateriaCaminonMinero.repositories;

import com.api.BateriaCaminonMinero.models.BateriasModel;
import com.api.BateriaCaminonMinero.models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface BateriaRepositoriy extends JpaRepository<BateriasModel, Long> {
    Optional<BateriasModel> findByNombre(String nombre);
    List<BateriasModel> findByCamionesModelId(Long camionId);

    List<BateriasModel> findByEmpresasModelId(Long empresaId);

    @Query("SELECT " +
            "   b.camionesModel.id AS idCamion, " +
            "   ROUND(AVG(b.voltaje), 2) AS voltajeAVG, " +  // Redondear a 2 decimales
            "   ROUND(AVG(b.carga), 2) AS cargaAVG, " +      // Redondear a 2 decimales
            "   ROUND(AVG(b.corriente), 2) AS corrienteAVG " +  // Redondear a 2 decimales
            "FROM BateriasModel b " +
            "WHERE b.camionesModel.id = :camionId " +
            "GROUP BY b.camionesModel.id")
    List<Map<String, Object>> getBateriaStatsByCamionId(@Param("camionId") Long camionId);


    /** **/


    List<BateriasModel> findByEmpresasModelAndEstado(EmpresasModel empresasModel, Boolean estado);
}
