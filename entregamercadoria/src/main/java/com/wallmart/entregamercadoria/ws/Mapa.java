package com.wallmart.entregamercadoria.ws;

import java.util.HashSet;
import java.util.Set;

public class Mapa {
	
	private String nome;
	private Set<Caminho> caminhos = new HashSet<Caminho>();
	
	public Mapa() {
		super();
	}
	public Mapa(String nome) {
		super();
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Caminho> getCaminhos() {
		return caminhos;
	}
	public void setCaminhos(Set<Caminho> caminhos) {
		this.caminhos = caminhos;
	}
	
}