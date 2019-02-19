package com.planets.Star.Wars.API;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.planets.Star.Wars.API.models.Planet;
import com.planets.Star.Wars.API.repositories.PlanetRepository;
import com.planets.Star.Wars.API.services.PlanetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarWarsPlanetsServiceTests {
	
	@Mock
	private PlanetRepository planetRepository;
	
	@InjectMocks
	private PlanetService planetService;
	
	private Planet planeta;
	
	@Before
	public void create_template() {
		planeta = new Planet();
		planeta.setNome("Vênus");
		planeta.setClima("Tropical");
		planeta.setQtdAparicoes(new Long(10));
		planeta.setTerreno("arenoso");
	}
	
	@Test
	public void test_lista_planetas() {
		when(planetRepository.findAll()).thenReturn(Arrays.asList(planeta, planeta, planeta));
		Assert.assertNotNull(planetService.listaPlanetasBanco());
	}
	
	@Test
	public void test_encontra_planeta_por_nome() {
		when(planetRepository.findByNome(planeta.getNome())).thenReturn(Optional.of(planeta));
		Assert.assertEquals(planetService.encontrePlanetaPorNome(planeta.getNome()), planeta);
	}
	
	@Test
	public void test_encontra_planeta_por_id() {
		when(planetRepository.findById(planeta.getId())).thenReturn(Optional.of(planeta));
		Assert.assertEquals(planetService.encontrePlanetaPorId(planeta.getId()), planeta);
	}
}	
	
	
	
	
