package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record dtoDatosActualizarCurso(
        @NotBlank
        Long id,
        String nombre ,
        String categoria,
        Boolean activo
) {
}
