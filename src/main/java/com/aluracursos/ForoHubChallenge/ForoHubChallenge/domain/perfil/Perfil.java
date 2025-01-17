package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil;


import jakarta.persistence.*;
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
}
