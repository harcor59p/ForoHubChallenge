package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso.Curso;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record dtoDatosActualizarTopico(
        @NotNull
        Long id,
        String titulo ,
        String mensaje ,
        LocalDateTime fecha_creacion,
        Status status ,
        Usuario usuario,
        Curso curso,
        Boolean activo

) {
}
