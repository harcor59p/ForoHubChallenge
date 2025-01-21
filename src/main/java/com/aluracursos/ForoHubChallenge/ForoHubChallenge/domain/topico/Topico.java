package com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso.Curso;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil.dtoDatosActualizarPerfil;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil.dtoDatosRegistroPerfil;
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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo ;
    private String mensaje;
    private LocalDateTime fechaCreacion ;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso ;
    private Boolean activo ;



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

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

    public Topico(dtoDatosRegistroTopico dtoDatosRegistroTopico) {
        this.activo = true ;
        this.titulo = dtoDatosRegistroTopico.titulo();
        this.mensaje = dtoDatosRegistroTopico.mensaje();
        this.fechaCreacion = dtoDatosRegistroTopico.fechaCreacion() ;
        this.status = dtoDatosRegistroTopico.status() ;
        this.curso = dtoDatosRegistroTopico.curso() ;


    }

    public void actualizarDatos(@Valid dtoDatosActualizarTopico dtoDatosActualizarTopico) {
        if(dtoDatosActualizarTopico.titulo() != null){
            this.titulo() = dtoDatosActualizarTopico.titulo();
        }
        if(dtoDatosActualizarTopico.activo() != null){
            this.activo = dtoDatosActualizarTopico.activo();
        }

    }
}
