package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil.Perfil;

public record dtoDatosListadoUsuario(
        Long id , String nombre , String email ,  Perfil perfil , Boolean activo
) {
    public dtoDatosListadoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNombre() , usuario.getEmail() , usuario.getPerfil() , usuario.getActivo() );
    }
}
