package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso , Long> {
    Page<Curso> findAll(Pageable paginacion);
}
