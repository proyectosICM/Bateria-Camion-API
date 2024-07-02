package com.api.BateriaCaminonMinero.repositories;

import com.api.BateriaCaminonMinero.models.BateriasModel;
import com.api.BateriaCaminonMinero.models.DetalleBateriasModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DetalleBateriasRepository extends JpaRepository<DetalleBateriasModel, Long> {
    List<DetalleBateriasModel> findByBateriasModelIdOrderByDiaDescHoraDesc(Long bateriaId);

    Page<DetalleBateriasModel> findByBateriasModelIdOrderByDiaDescHoraDesc(Long bateriaId, Pageable pageable);


    @Query("SELECT " +
            "HOUR(d.hora) AS hora, " +
            "AVG(d.voltaje) AS voltajePromedio, " +
            "AVG(d.Corriente) AS corrientePromedio, " +
            "AVG(d.carga) AS cargaPromedio, " +
            "AVG(d.temperatura) AS temperaturaPromedio " +
            "FROM DetalleBateriasModel d " +
            "WHERE d.bateriasModel.id = :bateriaId AND d.dia = CURRENT_DATE " +
            "GROUP BY HOUR(d.hora) " +
            "ORDER BY hora")
    List<Object[]> findHourlyAveragesForToday(@Param("bateriaId") Long bateriaId);

    @Query("SELECT " +
            "d.dia AS dia, " +
            "AVG(d.voltaje) AS voltajePromedio, " +
            "AVG(d.Corriente) AS corrientePromedio, " +
            "AVG(d.carga) AS cargaPromedio, " +
            "AVG(d.temperatura) AS temperaturaPromedio " +
            "FROM DetalleBateriasModel d " +
            "WHERE d.bateriasModel.id = :bateriaId " +
            "GROUP BY d.dia " +
            "ORDER BY d.dia")
    List<Object[]> findDailyAverages(@Param("bateriaId") Long bateriaId);

    @Query("SELECT " +
            "YEAR(d.dia) AS year, " +
            "MONTH(d.dia) AS month, " +
            "AVG(d.voltaje) AS voltajePromedio, " +
            "AVG(d.Corriente) AS corrientePromedio, " +
            "AVG(d.carga) AS cargaPromedio, " +
            "AVG(d.temperatura) AS temperaturaPromedio " +
            "FROM DetalleBateriasModel d " +
            "WHERE d.bateriasModel.id = :bateriaId " +
            "GROUP BY YEAR(d.dia), MONTH(d.dia) " +
            "ORDER BY year, month")
    List<Object[]> findMonthlyAverages(@Param("bateriaId") Long bateriaId);
    /** **/

    List<DetalleBateriasModel> findByIdAndDia(Long id, Date dia);

    List<DetalleBateriasModel> findByDia(Date dia);
/*
    DetalleBateriasModel findByBateriasModelAndDia(BateriasModel bateriasModel, Date dia);
*/
    @Query("SELECT d FROM DetalleBateriasModel d WHERE d.bateriasModel.id = :bateriaId AND " +
            "d.dia = (SELECT MAX(dia) FROM DetalleBateriasModel WHERE bateriasModel.id = :bateriaId)")
    List<DetalleBateriasModel> DetallesUltimoDiaPorBateria(@Param("bateriaId") Long bateriaId);

    @Query(value = "CALL PromedioDetalleDiaxMes(:bateria)", nativeQuery = true)
    List<Object[]> PromedioDetalleDiaxMes(@Param("bateria") Long bateria);

    @Query("SELECT MONTH(d.dia) AS mes, COUNT(*) AS total_registros, AVG(d.voltaje) AS voltajepromedio, " +
            "AVG(d.carga) AS cargapromedio, AVG(d.Corriente) AS corrientePromedio, AVG(d.temperatura) AS temperaturapromedio " +
            "FROM DetalleBateriasModel d " +
            "WHERE YEAR(d.dia) = YEAR(CURRENT_DATE()) AND d.bateriasModel.id = :bateriaId " +
            "GROUP BY MONTH(d.dia)")
    List<Object[]> PromediosxBateria(@Param("bateriaId") Long bateriaId);
}
