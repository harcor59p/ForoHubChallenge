package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil.Perfil;

public record dtoDatosRespuestaUsuario(
        Long id , String nombre , String email ,  Perfil perfil , Boolean activo
) {

}
