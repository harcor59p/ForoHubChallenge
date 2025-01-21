package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso.Curso;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo ;
    private String mensaje;
    private LocalDateTime fecha_creacion;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private Curso curso ;
    private Boolean activo ;

    public Topico() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Topico( @Valid dtoDatosRegistroTopico dtoDatosRegistroTopico , Usuario usuario , Curso curso ) {
        this.activo = true ;
        this.titulo = dtoDatosRegistroTopico.titulo();
        this.mensaje = dtoDatosRegistroTopico.mensaje();
        this.fecha_creacion = dtoDatosRegistroTopico.fecha_creacion() ;
        this.status = dtoDatosRegistroTopico.status() ;
        this.usuario = usuario;
        this.curso = curso ;


    }


    public void actualizarDatos(@Valid dtoDatosActualizarTopico dtoDatosActualizarTopico) {
        if(dtoDatosActualizarTopico.titulo() != null){
            this.titulo = dtoDatosActualizarTopico.titulo();
        }
        if(dtoDatosActualizarTopico.mensaje() != null){
            this.mensaje = dtoDatosActualizarTopico.mensaje();
        }
        if(dtoDatosActualizarTopico.fecha_creacion() != null){
            this.fecha_creacion = dtoDatosActualizarTopico.fecha_creacion();
        }
        if(dtoDatosActualizarTopico.status() != null){
            this.status = dtoDatosActualizarTopico.status();
        }
        if(dtoDatosActualizarTopico.curso() != null){
            this.curso = dtoDatosActualizarTopico.curso();
        }
        if(dtoDatosActualizarTopico.activo() != null){
            this.activo = dtoDatosActualizarTopico.activo();
        }

    }
}
