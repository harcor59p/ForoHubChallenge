package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "perfiles")
@Entity(name = "Perfil")
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Boolean activo ;

    public Perfil() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Perfil(dtoDatosRegistroPerfil dtoDatosRegistroPerfil) {
        this.activo = true ;
        this.nombre = dtoDatosRegistroPerfil.nombre();

    }

    public void actualizarDatos(@Valid dtoDatosActualizarPerfil dtoDatosActualizarPerfil) {
        if(dtoDatosActualizarPerfil.nombre() != null){
            this.nombre = dtoDatosActualizarPerfil.nombre();
        }
        if(dtoDatosActualizarPerfil.activo() != null){
            this.activo = dtoDatosActualizarPerfil.activo();
        }

    }
}


