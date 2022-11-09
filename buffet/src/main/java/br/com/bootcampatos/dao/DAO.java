package br.com.bootcampatos.dao;

import javax.persistence.EntityManager;

import br.com.bootcampatos.model.Cliente;
import br.com.bootcampatos.model.Contrato;

public class DAO<E> {
    EntityManager em;

    public DAO(EntityManager em) {
        this.em = em;
    }

    public void insert(E entity) {
        this.em.getTransaction().begin();
        this.em.persist(entity);
        this.em.getTransaction().commit();
        this.em.close();
    }


}