package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso.Curso;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record dtoDatosListadoTopico(
        Long id , String titulo , String mensaje , LocalDateTime fechaCreacion , Status status , Usuario usuario , Curso curso
) {
    public dtoDatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje() , topico.getFechaCreacion() , topico.getStatus() , topico.getUsuario() , topico.getCurso()) ;
    }

}
