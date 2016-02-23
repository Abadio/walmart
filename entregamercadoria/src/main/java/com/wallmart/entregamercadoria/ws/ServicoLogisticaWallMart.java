package com.wallmart.entregamercadoria.ws;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.commons.collections15.Transformer;

import com.wallmart.entregamercadoria.dao.GrafoDaoImpl;
import com.wallmart.entregamercadoria.model.Link;
import com.wallmart.entregamercadoria.model.Vertice;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;

@WebService
public class ServicoLogisticaWallMart{

	//DI via Spring
	private GrafoDaoImpl grafoDaoImpl;

	@WebMethod(exclude=true)
	public void setGrafoDaoImpl(GrafoDaoImpl grafoDaoImpl) {
		this.grafoDaoImpl = grafoDaoImpl;
	}
	private Map<String, InfGrafo> listaMapas = new HashMap<String, InfGrafo>();

	@WebMethod(operationName="carregarMapa")
	public boolean carregarMapa(Mapa mapa) {
		
		try {
			if (!listaMapas.containsKey(mapa.getNome())) {
				
				Map<String, Vertice> vertices = new HashMap<String, Vertice>();
				for (Caminho caminho : mapa.getCaminhos()) {
					
					if (!vertices.containsKey(caminho.getOrigem()))
						vertices.put(caminho.getOrigem(), new Vertice(caminho.getOrigem()));
					
					if (!vertices.containsKey(caminho.getDestino()))
						vertices.put(caminho.getDestino(), new Vertice(caminho.getDestino()));
											
				}
				
				Graph<Vertice, Link> grafo = new SparseMultigraph<Vertice, Link>();

				Set<Link> links = new HashSet<Link>();
				for (Caminho caminho : mapa.getCaminhos()) {
					links.add(new Link(vertices.get(caminho.getOrigem()), vertices.get(caminho.getDestino()), caminho.getDistancia()));
				}	
				
				for (Link link : links) {
					grafo.addEdge(link, link.getOrigem(), link.getDestino());
				}
				
				listaMapas.put(mapa.getNome(), new InfGrafo(grafo, vertices));
				
			}
			
			return true;
		} catch (Exception e) {
			
			//posteriormente disparar exceções tipadas tornaria as regras de negócio mais consistentes.
			return false;
			//throw new ExceptionTipada("mensagem");
		}
			
		
	}
	
	public InfResultMenorCaminho localizarMenorCaminho(InfPercurso infPercurso ) {
		
		 InfResultMenorCaminho result = null; 
		
		if (listaMapas.containsKey(infPercurso.getMapa())) {
		
			Transformer<Link, Double> wtTransformer = new Transformer<Link,Double>() {
				public Double transform(Link link) {
					return link.getDistancia();
				}
			};	
			
			InfGrafo infGrafo = listaMapas.get(infPercurso.getMapa());
			 DijkstraShortestPath<Vertice,Link> algoritmoDijkstra = new DijkstraShortestPath<Vertice,Link>(infGrafo.getGrafo(),
					 wtTransformer);
			 
			 List<Link> menorCaminhoOrigemDestino = algoritmoDijkstra.getPath(infGrafo.getVertices().get(infPercurso.getOrigem()), infGrafo.getVertices().get(infPercurso.getDestino()));
			 Number distanciaMenorCaminho = algoritmoDijkstra.getDistance(infGrafo.getVertices().get(infPercurso.getOrigem()), infGrafo.getVertices().get(infPercurso.getDestino()));
			 
			 StringBuilder mensagem = new StringBuilder();
			 mensagem.append("O caminho mais curto entre " + infPercurso.getOrigem() + " e " + infPercurso.getDestino() + " é: ");
			 mensagem.append(menorCaminhoOrigemDestino.toString());
			 mensagem.append(" e a distancia é: " + distanciaMenorCaminho);	
			 
			 Number custo = distanciaMenorCaminho.doubleValue() / infPercurso.getAutonomia() * infPercurso.getValorLitro();
			 mensagem.append(" e o custo para realizar o percurso é " + custo);
			 
			 result = new InfResultMenorCaminho(mensagem.toString(), custo.doubleValue());
			
		}
		
		return result;
	}
 
}