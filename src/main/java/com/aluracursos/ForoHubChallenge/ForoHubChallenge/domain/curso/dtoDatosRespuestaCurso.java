package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record dtoDatosRespuestaCurso(
        Long id ,  String nombre , String categoria , Boolean activo
) {

}
