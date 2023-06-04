package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.CamionesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamionesRepository extends JpaRepository<CamionesModel, Long> {
}
