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

}
