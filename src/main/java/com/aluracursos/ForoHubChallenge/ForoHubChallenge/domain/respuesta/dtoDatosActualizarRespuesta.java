package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.respuesta;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico.Topico;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.Usuario;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record dtoDatosActualizarRespuesta(
        @NotBlank
        Long id,
        String mensaje ,
        @NotBlank
        Topico topico ,
        @NotNull
        @Future
        LocalDateTime fechaCreacion ,
        @NotNull
        Usuario usuario,
        String solucion ,
        Boolean activo

) {
}
