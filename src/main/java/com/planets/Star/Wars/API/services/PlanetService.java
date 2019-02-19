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
    
    public Planet adicionaPlaneta (Planet planeta) {
    		Planet outroPlaneta = planetRepository.findByNome(planeta.getNome());
    		Planet planetaAdicionado = new Planet();
        if(outroPlaneta == null) {
        		planetaAdicionado =	planetRepository.save(planeta);
        		return planetaAdicionado;
        }
		return null;
    }

    public List<Planet> listaPlanetasBanco() {
        List<Planet> planetas = planetRepository.findAll();
        return planetas;
    }

    public List<Planet> listaPlanetasAPI() {
        List<Planet> planetas = planetRepository.findAll();
        return planetas;
    }

    public Planet encontrePlanetaPorNome(String nome) {
        Planet planeta = planetRepository.findByNome(nome);
        return planeta;
    }

    public Planet encontrePlanetaPorId(Long id) {
        Optional<Planet> planeta = planetRepository.findById(id);
        return planeta.orElse(null);
    }

    public void removePlaneta(Long id) {
		Optional<Planet> outroPlaneta = planetRepository.findById(id);
		if(outroPlaneta != null) {
			planetRepository.deleteById(id);
		}
    }
}
