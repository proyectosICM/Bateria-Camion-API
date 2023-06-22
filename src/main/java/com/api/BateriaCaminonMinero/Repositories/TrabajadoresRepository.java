package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrabajadoresRepository extends JpaRepository<TrabajadoresModel, Long> {

    @Query(value = "CALL TRABAJADORXEMPT(:emp)", nativeQuery = true)
    List<Object[]> ListTrabjadorxEmpT(@Param("emp") Long emp);

    @Query(value = "CALL TRABAJADORXEMPH(:est, :emp)", nativeQuery = true)
    List<Object[]>ListTrabjadorxEmpH(@Param("est") Boolean est, @Param("emp") Long emp );
}
