package com.aluracursos.ForoHubChallenge.ForoHubChallenge.controller;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil.*;
import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/topicos")
public class TopicolController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<dtoDatosRespuestaTopico> registrarTopíco(@RequestBody @Valid dtoDatosRegistroTopico dtoDatosRegistroTopico,
                                                                   UriComponentsBuilder uriComponentsBuilder) {
        // Validación explícita se debe ejecutar
        Topico topico = topicoRepository.save(new Topico(dtoDatosRegistroTopico));
        dtoDatosRespuestaTopico dtoDatosRespuestaTopico = new dtoDatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje() ,
                topico.getFechaCreacion() , topico.getStatus() , topico.getUsuario() , topico.getCurso() , topico.getActivo());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(dtoDatosRespuestaTopico);
    }




    @GetMapping
    public ResponseEntity<Page<dtoDatosListadoTopico>> listadoTopicoes(@PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(dtoDatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<dtoDatosRespuestaTopico> actualizarTopico(@RequestBody @Valid dtoDatosActualizarTopico dtoDatosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(dtoDatosActualizarTopico.id());
        topico.actualizarDatos(dtoDatosActualizarTopico) ;
        return ResponseEntity.ok(new dtoDatosRespuestaTopico(topico.getId() , topico.getNombre(), topico.getActivo()));
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
        var datosTopico = new dtoDatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getActivo());
        return ResponseEntity.ok(datosTopico);
    }

}
