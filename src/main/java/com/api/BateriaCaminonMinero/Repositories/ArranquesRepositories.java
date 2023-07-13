package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.ArranquesModel;
import com.api.BateriaCaminonMinero.Models.CamionesModel;
import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArranquesRepositories extends JpaRepository<ArranquesModel, Long> {
    List<ArranquesModel> findByCamionesModel(CamionesModel camionesModel);
    List<ArranquesModel> findByEmpresasModelAndCamionesModel(EmpresasModel empresasModel, CamionesModel camionesModel);

    @Query("SELECT a FROM ArranquesModel a WHERE MONTH(a.dia) = :mes")
    List<ArranquesModel> findByMes(int mes);

    @Query("SELECT MONTH(a.dia) AS mes, AVG(a.corriente) AS promedio_corriente, a.camionesModel, a.empresasModel FROM ArranquesModel a WHERE a.camionesModel.id = :camion GROUP BY MONTH(a.dia)")
    List<Object[]> PromediosxCamion(int camion);
}
