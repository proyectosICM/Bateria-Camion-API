package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.TrabajadoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TrabajadoresRepository extends JpaRepository<TrabajadoresModel, Long> {
}
