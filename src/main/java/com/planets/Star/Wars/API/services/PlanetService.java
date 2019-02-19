package com.planets.Star.Wars.API.services;

import com.planets.Star.Wars.API.models.Planet;
import com.planets.Star.Wars.API.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository planetRepository;

    public void adicionaPlaneta (Planet planeta) {
        planetRepository.save(planeta);
    }

    public List<Planet> listaPlanetasBanco() {
        List<Planet> planetas = planetRepository.findAll();
        return planetas;
    }

    public List<Planet> listaPlanetasAPI() {
        List<Planet> planetas = planetRepository.findAll();
        return planetas;
    }

    public List<Planet> encontrePlanetasPorNome(String nome) {
        Optional<List<Planet>> planetas = planetRepository.findByNome(nome);
        return planetas.orElse(null);
    }

    public Planet encontrePlanetaPorId(Long id) {
        Optional<Planet> planeta = planetRepository.findById(id);
        return planeta.orElse(null);
    }

    public void removePlaneta(Long id) {
        planetRepository.deleteById(id);
    }
}
