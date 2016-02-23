package com.wallmart.entregamercadoria.ws;

public class Caminho {
	
	private String origem;
	private String destino;
	private Double distancia;
	
	public Caminho() {
		super();
	}

	public Caminho(String origem, String destino, Double distancia) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}
	
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	
}
