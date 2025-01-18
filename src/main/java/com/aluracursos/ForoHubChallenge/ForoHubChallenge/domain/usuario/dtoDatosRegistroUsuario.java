package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record dtoDatosRegistroUsuario(
        @NotBlank
        Long id,
        @NotBlank
        String nombre ,
        @NotBlank
        @Email
        String email ,
        @NotNull
        String Password ,
        @NotNull
        Perfil perfil

) {
}
