package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso;

public record dtoDatosListadoCurso(
        Long id , String nombre , String categoria
) {
    public dtoDatosListadoCurso(Curso curso){
        this(curso.getId(), curso.getNombre() , curso.getCategoria());
    }
}
