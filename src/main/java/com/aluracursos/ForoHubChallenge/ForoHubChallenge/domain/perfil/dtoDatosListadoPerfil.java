package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil;

public record dtoDatosListadoPerfil(
        Long id , String nombre
) {
    public dtoDatosListadoPerfil(Perfil perfil){
        this(perfil.getId(), perfil.getNombre() );
    }
}
