package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil;

public record dtoDatosListadoPerfil(
        Long id , String nombre , Boolean activo
) {
    public dtoDatosListadoPerfil(Perfil perfil){
        this(perfil.getId(), perfil.getNombre() , perfil.getActivo());
    }
}
