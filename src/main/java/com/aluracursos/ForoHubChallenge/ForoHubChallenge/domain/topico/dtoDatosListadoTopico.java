package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso.Curso;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record dtoDatosListadoTopico(
        Long id , String titulo , String mensaje , LocalDateTime fecha_creacion, String status , Usuario usuario , Curso curso , Boolean activo
) {
    public dtoDatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje() , topico.getFecha_creacion() , topico.getStatus().toString() , topico.getUsuario() , topico.getCurso() , topico.getActivo()) ;
    }

}
