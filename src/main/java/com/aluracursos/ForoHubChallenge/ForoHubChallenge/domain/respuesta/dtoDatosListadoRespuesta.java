package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.respuesta;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico.Topico;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record dtoDatosListadoRespuesta(
        Long id , String mensaje , Topico topico ,  LocalDateTime fechaCreacion , Usuario usuario , String solucion , Boolean activo
) {
    public dtoDatosListadoRespuesta(Respuesta respuesta){
        this(respuesta.getId(),  respuesta.getMensaje() , respuesta.getTopico() ,  respuesta.getFechaCreacion() ,  respuesta.getUsuario() , respuesta.getSolucion() , respuesta.getActivo()) ;
    }

}
