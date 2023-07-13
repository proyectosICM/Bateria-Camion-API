package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.ArranquesModel;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArranquesRepositories extends JpaRepository<ArranquesModel, Long> {
    List<ArranquesModel> findByCamionesModel(CamionesModel camionesModel);
    List<ArranquesModel> findByEmpresasModelAndCamionesModel(EmpresasModel empresasModel, CamionesModel camionesModel);

    @Query(value = "CALL PromedioArranquesDiaxMes(:camion)", nativeQuery = true)
    List<Object[]> PromedioCorrienteUltimoMes(@Param("camion") int camion);

    //Promedio de año(cada mes) y conteo del año
    @Query("SELECT MONTH(a.dia) AS mes, AVG(a.corriente) AS promedio_corriente, a.camionesModel, a.empresasModel FROM ArranquesModel a WHERE YEAR(a.dia) = YEAR(CURRENT_DATE()) AND a.camionesModel.id = :camion GROUP BY MONTH(a.dia)")
    List<Object[]> PromediosxCamion(int camion);
    @Query("SELECT YEAR(a.dia) AS fecha, COUNT(*) AS total_registros, a.camionesModel FROM ArranquesModel a WHERE a.camionesModel.id = :camion GROUP BY YEAR(a.dia)")
    List<Object[]> ConteoDeRegistrosxYears(int camion);

}
