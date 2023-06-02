package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.DetallesCamionesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DetallesCamionRepository extends JpaRepository<DetallesCamionesModel, Long> {
    @Query(value = "CALL DETALLESVALORES(:camion)", nativeQuery = true)
    List<Object[]> getDetallesValores(@Param("camion") int camion);
}
