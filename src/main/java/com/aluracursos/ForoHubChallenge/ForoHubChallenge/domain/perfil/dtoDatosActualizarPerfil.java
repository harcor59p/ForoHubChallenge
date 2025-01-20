package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil;

import jakarta.validation.constraints.NotNull;

public record dtoDatosActualizarPerfil(
        @NotNull
        Long id,
        String nombre ,
        Boolean activo
) {
}
