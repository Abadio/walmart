package com.wallmart.entregamercadoria.ws;

import java.util.Map;

import com.wallmart.entregamercadoria.model.Link;
import com.wallmart.entregamercadoria.model.Vertice;

import edu.uci.ics.jung.graph.Graph;

public class InfGrafo {
	
	private Graph<Vertice, Link> grafo;
	private Map<String, Vertice> vertices;
	
	public InfGrafo(Graph<Vertice, Link> grafo, Map<String, Vertice> vertices) {
		super();
		this.grafo = grafo;
		this.vertices = vertices;
	}
	public Graph<Vertice, Link> getGrafo() {
		return grafo;
	}
	public void setGrafo(Graph<Vertice, Link> grafo) {
		this.grafo = grafo;
	}
	public Map<String, Vertice> getVertices() {
		return vertices;
	}
	public void setVertices(Map<String, Vertice> vertices) {
		this.vertices = vertices;
	}
	
	
	
}
