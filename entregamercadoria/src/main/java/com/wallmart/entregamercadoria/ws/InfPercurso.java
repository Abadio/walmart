package com.wallmart.entregamercadoria.ws;

public class InfPercurso {
	
	private String mapa;
	private String origem;
	private String destino;
	private Double autonomia;
	private Double valorLitro;
	
	public InfPercurso() {
		super();
	}

	public InfPercurso(String mapa, String origem, String destino, Double autonomia, Double valorLitro) {
		super();
		this.mapa = mapa;
		this.origem = origem;
		this.destino = destino;
		this.autonomia = autonomia;
		this.valorLitro = valorLitro;
	}

	public String getMapa() {
		return mapa;
	}

	public void setMapa(String mapa) {
		this.mapa = mapa;
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

	public Double getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(Double autonomia) {
		this.autonomia = autonomia;
	}

	public Double getValorLitro() {
		return valorLitro;
	}

	public void setValorLitro(Double valorLitro) {
		this.valorLitro = valorLitro;
	}
	
	

}
