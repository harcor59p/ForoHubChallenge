package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso.Curso;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record dtoDatosRespuestaTopico(
        Long id , String titulo , String mensaje , LocalDateTime fechaCreacion , Status status , Usuario usuario , Curso curso , Boolean activo
) {

}
