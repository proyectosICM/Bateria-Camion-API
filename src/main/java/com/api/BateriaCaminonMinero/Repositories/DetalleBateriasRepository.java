package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.BateriasModels;
import com.api.BateriaCaminonMinero.Models.DetalleBateriasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface DetalleBateriasRepository extends JpaRepository<DetalleBateriasModel, Long> {
    List<DetalleBateriasModel> findByBateriasModels(BateriasModels bateriasModels);
    List<DetalleBateriasModel> findByIdAndDia(Long id , Date dia);
    List<DetalleBateriasModel> findByDia(Date dia);

    DetalleBateriasModel findByBateriasModelsAndDia(Long id , Date dia);

    @Query("SELECT MONTH(d.dia) AS mes, COUNT(*) AS total_registros, AVG(d.voltaje) AS voltajepromedio, AVG(d.carga) AS cargapromedio, AVG(d.Corriente) AS corrientePromedio, AVG(d.temperatura) AS temperaturapromedio " +
            "FROM DetalleBateriasModel d " +
            "WHERE YEAR(d.dia) = YEAR(CURRENT_DATE()) AND d.bateriasModels.id = :bateriaId " +
            "GROUP BY MONTH(d.dia)")
    List<Object[]> PromediosxBateria(@Param("bateriaId") Long bateriaId);


}
