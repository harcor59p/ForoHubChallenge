package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil;

import jakarta.validation.constraints.NotBlank;

public record dtoDatosActualizarPerfil(
        @NotBlank
        Long id,
        String nombre ,
        Boolean activo
) {
}
