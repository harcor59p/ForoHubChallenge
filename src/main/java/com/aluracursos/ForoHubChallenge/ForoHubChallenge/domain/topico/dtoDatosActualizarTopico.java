package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso.Curso;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record dtoDatosActualizarTopico(
        @NotBlank
        Long id,
        String titulo ,
        String mensaje ,
        LocalDateTime fechaCreacion ,
        Status status ,
        Usuario usuario,
        Curso curso

) {
}
