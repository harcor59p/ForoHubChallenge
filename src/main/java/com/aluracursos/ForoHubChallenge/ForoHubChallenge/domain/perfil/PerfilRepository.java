package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Page<Perfil> findAllByActivoTrue(Pageable paginacion);

}

