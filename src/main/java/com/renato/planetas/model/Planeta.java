package com.renato.planetas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Planeta implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	private String nome;
	private String clima;
	private String terreno;
	private int quantidadeAparicoes;
	
	
	public Planeta() {
		
	}
	
	public Planeta(String nome, String clima, String terreno) {
		super();
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public int getQuantidadeAparicoes() {
		return quantidadeAparicoes;
	}
	public void setQuantidadeAparicoes(int quantidadeAparicoes) {
		this.quantidadeAparicoes = quantidadeAparicoes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
