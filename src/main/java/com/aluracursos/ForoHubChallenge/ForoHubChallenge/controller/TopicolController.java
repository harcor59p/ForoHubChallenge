package com.aluracursos.ForoHubChallenge.ForoHubChallenge.controller;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso.Curso;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.curso.CursoRepository;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico.*;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.Usuario;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/topicos")
public class TopicolController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository ;

    @Autowired
    private CursoRepository cursoRepository ;

    @PostMapping
    public ResponseEntity<dtoDatosRespuestaTopico> registrarTopico(
            @RequestBody @Valid dtoDatosRegistroTopico dtoDatosRegistroTopico,
            UriComponentsBuilder uriComponentsBuilder) {

        Usuario usuario = usuarioRepository.findById(dtoDatosRegistroTopico.usuario_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
        Curso curso = cursoRepository.findById(dtoDatosRegistroTopico.curso_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado"));

        Topico topico = new Topico(dtoDatosRegistroTopico, usuario, curso);
        topicoRepository.save(topico);

        dtoDatosRespuestaTopico dtoDatosRespuestaTopico = new dtoDatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha_creacion(),
                topico.getStatus().toString(),
                topico.getUsuario(),
                topico.getCurso(),
                topico.getActivo()
        );

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(dtoDatosRespuestaTopico);
    }


//    @PostMapping
//    public ResponseEntity<dtoDatosRespuestaTopico> registrarTopico(@RequestBody @Valid dtoDatosRegistroTopico dtoDatosRegistroTopico,
//                                                                   UriComponentsBuilder uriComponentsBuilder
//    ) {
//        // Validación explícita se debe ejecuta
//        Topico topico = topicoRepository.save(new Topico(dtoDatosRegistroTopico ));
//        dtoDatosRespuestaTopico dtoDatosRespuestaTopico = new dtoDatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje() ,
//                topico.getFecha_creacion() , topico.getStatus().toString() , topico.getUsuario(), topico.getCurso() , topico.getActivo());
//        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
//        return ResponseEntity.created(url).body(dtoDatosRespuestaTopico);
//    }

    @GetMapping
    public ResponseEntity<Page<dtoDatosListadoTopico>> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(dtoDatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<dtoDatosRespuestaTopico> actualizarTopico(@RequestBody @Valid dtoDatosActualizarTopico dtoDatosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(dtoDatosActualizarTopico.id());
        topico.actualizarDatos(dtoDatosActualizarTopico) ;
        return ResponseEntity.ok(new dtoDatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje() ,
                topico.getFecha_creacion() , topico.getStatus().toString() , topico.getUsuario() , topico.getCurso() , topico.getActivo()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<dtoDatosRespuestaTopico> retornarDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new dtoDatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje() ,
                topico.getFecha_creacion() , topico.getStatus().toString() , topico.getUsuario() , topico.getCurso() , topico.getActivo());
        return ResponseEntity.ok(datosTopico);
    }

}
