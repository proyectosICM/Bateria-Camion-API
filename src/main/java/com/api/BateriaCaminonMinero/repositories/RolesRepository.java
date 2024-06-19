package com.api.BateriaCaminonMinero.repositories;

import com.api.BateriaCaminonMinero.models.ERole;
import com.api.BateriaCaminonMinero.models.RolesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<RolesModel, Long> {
    Optional<RolesModel> findByName(ERole name);
}
