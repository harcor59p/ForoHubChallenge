package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.respuesta;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico.Topico;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record dtoDatosRespuestaRespuesta(
        Long id , String mensaje , Topico topico , LocalDateTime fechaCreacion , Usuario usuario , String solucion , Boolean activo
) {

}
