package com.planets.Star.Wars.API.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Planet {

    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    
    private String clima;
    
    private String terreno;
    
    private Long qtdAparicoes;
    
    public Planet(Long id, String nome, String clima, String terreno, Long qtdAparicoes) {
    	super();
    	this.id = id;
    	this.nome = nome;
    	this.clima = clima;
    	this.terreno = terreno;
    	this.qtdAparicoes = qtdAparicoes;
    }
    
    public Planet() {
    	
    }
    
    public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getClima() {
		return clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public Long getQtdAparicoes() {
		return qtdAparicoes;
	}
    
    public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public void setQtdAparicoes(Long qtdAparicoes) {
		this.qtdAparicoes = qtdAparicoes;
	}

}
