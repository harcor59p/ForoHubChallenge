package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil.Perfil;

public record dtoDatosListadoUsuario(
        Long id , String nombre , String email ,  Perfil perfil
) {
    public dtoDatosListadoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNombre() , usuario.getEmail() , usuario.getPerfil() );
    }
}
