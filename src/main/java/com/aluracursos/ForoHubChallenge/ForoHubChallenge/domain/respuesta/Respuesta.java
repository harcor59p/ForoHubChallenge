package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.respuesta;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico.Topico;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico ;
    private LocalDateTime fechaCreacion ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario ;
    private String solucion ;


}
