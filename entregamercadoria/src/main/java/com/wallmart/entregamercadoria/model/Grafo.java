package com.wallmart.entregamercadoria.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Grafo {
	
	@Id
    @GeneratedValue
	private Long id;
	
	private String nome;
	
	@OneToMany
	private Set<Link> links = new HashSet<Link>();
	
	@OneToMany
	private Set<Vertice> vertices = new HashSet<Vertice>();
	
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
	public Set<Link> getLinks() {
		return links;
	}
	public void setLinks(Set<Link> links) {
		this.links = links;
	}
	public Set<Vertice> getVertices() {
		return vertices;
	}
	public void setVertices(Set<Vertice> vertices) {
		this.vertices = vertices;
	}
	
	

}
