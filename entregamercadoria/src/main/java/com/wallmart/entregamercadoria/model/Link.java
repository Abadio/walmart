package com.wallmart.entregamercadoria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Link {
	
	@Id
    @GeneratedValue
	private Long id;
	
	@ManyToOne
	private Vertice origem;
	
	@ManyToOne
	private Vertice destino;
	
	private Double distancia;
	
	public Link(Vertice origem, Vertice destino, Double distancia) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}

	public Vertice getOrigem() {
		return origem;
	}

	public void setOrigem(Vertice origem) {
		this.origem = origem;
	}

	public Vertice getDestino() {
		return destino;
	}

	public void setDestino(Vertice destino) {
		this.destino = destino;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Link " + origem.toString() + "->" + destino.toString();
	}
	
}
