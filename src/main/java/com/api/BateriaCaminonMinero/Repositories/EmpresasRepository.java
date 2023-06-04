package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.EmpresasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresasRepository extends JpaRepository<EmpresasModel, Long> {
}
