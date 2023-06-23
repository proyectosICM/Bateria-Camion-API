package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.DetalleBateriasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DetalleBateriasRepository extends JpaRepository<DetalleBateriasModel, Long> {
    @Query(value = "CALL DETALLESVALORES(:camion)", nativeQuery = true)
    List<Object[]> getDetallesValores(@Param("camion") int camion);

    @Query(value = "CALL CAMIONXBATERIA(:camion,:bateria)", nativeQuery = true)
    List<Object[]> getDetallesBaterias(@Param("camion") int camion, @Param("bateria") int bateria);
    @Query(value = "CALL CAMIONXBATERIAT(:camion,:bateria)", nativeQuery = true)
    List<Object[]> getDetallesBateriasT(@Param("camion") int camion, @Param("bateria") int bateria);

}
