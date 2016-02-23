package com.wallmart.entregamercadoria.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.wallmart.entregamercadoria.model.Grafo;
 
 
/**
 * DAO implementation for Person entity
 *  
 * @author DevCrumb.com
 */
@Transactional
public class GrafoDaoImpl {
 
    @PersistenceContext
    private EntityManager em;
     
    public Long save(Grafo grafo) {
        em.persist(grafo);
        return grafo.getId();
    }
     
    public Grafo getAllByNome(String nome) {
        return em.createQuery("SELECT g FROM Grafo g where g.nome = :nome", Grafo.class)
        		.setParameter("nome", nome)
        		.getSingleResult();
    }
}