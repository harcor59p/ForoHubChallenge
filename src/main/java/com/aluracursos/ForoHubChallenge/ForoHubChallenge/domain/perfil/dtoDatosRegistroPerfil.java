package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil;

import jakarta.validation.constraints.NotBlank;

public record dtoDatosRegistroPerfil(
        @NotBlank
        Long id,
        @NotBlank
        String nombre
) {
}
