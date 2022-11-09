package br.com.bootcampatos.dao;

import br.com.bootcampatos.model.Contrato;

import javax.persistence.EntityManager;
import java.util.List;

public class ContratoDao extends DAO<Contrato> {
    public ContratoDao(EntityManager em) {
        super(em);
    }


    public List<Contrato> findByNome(String nome){
        return em.createQuery("select u from Contrato u inner join u.cliente cliente where cliente.nome LIKE :nome",
                        Contrato.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }
    public Contrato findById(Long id){
        return em.find(Contrato.class, id);
    }
}

