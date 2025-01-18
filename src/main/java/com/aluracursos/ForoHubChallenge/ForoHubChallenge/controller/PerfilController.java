package com.aluracursos.ForoHubChallenge.ForoHubChallenge.controller;

import com.aluracursos.ForoHubChallenge.ForoHubChallenge.domain.perfil.*;
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
    public ResponseEntity<dtoDatosRespuestaPerfil> registrarPerfil(@RequestBody @Valid dtoDatosRegistroPerfil dtoDatosRegistroPerfil , UriComponentsBuilder uriComponentsBuilder){
        Perfil perfil = perfilRepository.save(new Perfil(dtoDatosRegistroPerfil)) ;
        dtoDatosRespuestaPerfil dtoDatosRespuestaPerfil = new dtoDatosRespuestaPerfil(perfil.getId() , perfil.getNombre());
        URI url = uriComponentsBuilder.path("/perfiles/{id}").buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(url).body(dtoDatosRespuestaPerfil);
    }

    @GetMapping
    public ResponseEntity<Page<dtoDatosListadoPerfil>> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion) {
        var perfil =  PerfilRepository.findAll(paginacion).map(dtoDatosListadoPerfil::new);
        return ResponseEntity.ok(perfil);
    }

}
