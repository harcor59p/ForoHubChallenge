package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "cursos")
@Entity(name = "curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre ;
    private String categoria ;

}
