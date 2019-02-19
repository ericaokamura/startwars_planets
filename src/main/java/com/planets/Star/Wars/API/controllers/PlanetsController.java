package com.planets.Star.Wars.API.controllers;

import com.planets.Star.Wars.API.models.Planet;
import com.planets.Star.Wars.API.services.PlanetService;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PlanetsController {

    @Autowired
    PlanetService planetService;

    @PostMapping(value= "/planets", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planet> adicionarPlaneta(@RequestBody() Planet planeta) {
        planetService.adicionaPlaneta(planeta);
        return new ResponseEntity<Planet>(planeta, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value="/planets", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Planet>> listaPlanetasBanco() {
        List<Planet> planetas = planetService.listaPlanetasBanco();
        return new ResponseEntity<List<Planet>>(planetas, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping(value="/planets/nome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planet> encontrePlanetaPorNome(@PathVariable("nome") String nome) {
        Planet planeta = planetService.encontrePlanetaPorNome(nome);
        return new ResponseEntity<Planet>(planeta, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping(value="/planets/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planet> encontrePlanetaPorId(@PathVariable("id") Long id) {
        Planet planeta = planetService.encontrePlanetaPorId(id);
        return new ResponseEntity<Planet>(planeta, new HttpHeaders(), HttpStatus.OK);
    }
    
    @DeleteMapping("/planets/id/{id}")
    public void removePlaneta(@PathVariable("id") Long id) {
        planetService.removePlaneta(id);
    }
    
}
