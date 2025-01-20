package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record dtoDatosActualizarUsuario(
        @NotBlank
        Long id,
        String nombre ,
        @NotBlank
        @Email
        String email ,
        String Password ,
        Perfil perfil ,
        Boolean activo

) {
}
