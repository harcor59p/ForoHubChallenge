package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "perfiles")
@Entity(name = "Perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public Perfil(@Valid dtoDatosRegistroPerfil dtoDatosRegistroPerfil) {
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
}
