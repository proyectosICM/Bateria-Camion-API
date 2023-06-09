package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.ERole;
import com.api.BateriaCaminonMinero.Models.RolesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<RolesModel, Long> {
    Optional<RolesModel> findByName(ERole name);
}
