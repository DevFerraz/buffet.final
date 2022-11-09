package br.com.bootcampatos.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.bootcampatos.model.Contrato;

public class ContratoDao extends DAO<Contrato> {
    public ContratoDao(EntityManager em) {
        super(em);
    }


    public List<Contrato> findByNome(String nome){
        return em.createQuery("select u from Contrato u inner join u.cliente cliente where cliente.nome = :nome",
                        Contrato.class)
                .setParameter("nome", nome)
                .getResultList();
    }
    public Contrato findById(Long id){
        return em.find(Contrato.class, id);
    }
}

