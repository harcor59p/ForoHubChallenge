package com.aluracursos.ForoHubChallenge.ForoHubChallenge.controller;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil.*;
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
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository ;

    @PostMapping
    public ResponseEntity<dtoDatosRespuestaPerfil> registrarPerfil(@RequestBody @Valid dtoDatosRegistroPerfil dtoDatosRegistroPerfil,
                                                                   UriComponentsBuilder uriComponentsBuilder) {
        // Validación explícita se debe ejecutar
        Perfil perfil = perfilRepository.save(new Perfil(dtoDatosRegistroPerfil));
        dtoDatosRespuestaPerfil dtoDatosRespuestaPerfil = new dtoDatosRespuestaPerfil(perfil.getId(), perfil.getNombre(), perfil.getActivo());
        URI url = uriComponentsBuilder.path("/perfiles/{id}").buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(url).body(dtoDatosRespuestaPerfil);
    }




    @GetMapping
    public ResponseEntity<Page<dtoDatosListadoPerfil>> listadoPerfiles(@PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(perfilRepository.findByActivoTrue(paginacion).map(dtoDatosListadoPerfil::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<dtoDatosRespuestaPerfil> actualizarPerfil(@RequestBody @Valid dtoDatosActualizarPerfil dtoDatosActualizarPerfil){
        Perfil perfil = perfilRepository.getReferenceById(dtoDatosActualizarPerfil.id());
        perfil.actualizarDatos(dtoDatosActualizarPerfil) ;
        return ResponseEntity.ok(new dtoDatosRespuestaPerfil(perfil.getId() , perfil.getNombre(), perfil.getActivo()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarPerfil(@PathVariable Long id){
        Perfil perfil = perfilRepository.getReferenceById(id);
        perfilRepository.delete(perfil);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<dtoDatosRespuestaPerfil> retornarDatosPerfil(@PathVariable Long id) {
        Perfil perfil = perfilRepository.getReferenceById(id);
        var datosPerfil = new dtoDatosRespuestaPerfil(perfil.getId(), perfil.getNombre(), perfil.getActivo());
        return ResponseEntity.ok(datosPerfil);
    }

}
