package com.wallmart.entregamercadoria.ws;

public class InfResultMenorCaminho {
	
	private String mensagem;
	private Double custo;
	
	public InfResultMenorCaminho() {
		super();
	}

	public InfResultMenorCaminho(String mensagem, Double custo) {
		super();
		this.mensagem = mensagem;
		this.custo = custo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}
	
	

}
