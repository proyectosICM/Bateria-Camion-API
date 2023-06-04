package com.api.BateriaCaminonMinero.Repositories;

import com.api.BateriaCaminonMinero.Models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuariosModel, Long> {
}
