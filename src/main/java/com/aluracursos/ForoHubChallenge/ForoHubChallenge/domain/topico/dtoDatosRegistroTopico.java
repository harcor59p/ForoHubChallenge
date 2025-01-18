package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso.Curso;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.Usuario;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record dtoDatosRegistroTopico(
        @NotBlank
        Long id,
        @NotBlank
        String titulo ,
        @NotBlank
        String mensaje ,
        @NotNull
        @Future
        LocalDateTime fechaCreacion ,
        @NotNull
        Status status ,
        @NotNull
        Usuario usuario,
        @NotNull
        Curso curso

) {
}
