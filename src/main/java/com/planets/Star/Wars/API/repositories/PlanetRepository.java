package com.planets.Star.Wars.API.repositories;

import com.planets.Star.Wars.API.models.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {

    List<Planet> findAll();

    Optional<Planet> findById(Long id);

    Planet findByNome(String nome);

}
