package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record dtoDatosRegistroCurso(
        @NotBlank
        Long id,
        @NotBlank
        String nombre ,
        @NotBlank
        String categoria ,
        @NotBlank
        Boolean activo
) {
}
