package br.com.fiap.traveller.dao.impl;

import br.com.fiap.traveller.dao.DAO;
import br.com.fiap.traveller.dao.generic.EnderecoDAO;
import br.com.fiap.traveller.entities.Endereco;

import javax.persistence.EntityManager;

public class EnderecoDAOImpl extends DAO<Endereco, Long> implements EnderecoDAO {
    public EnderecoDAOImpl(EntityManager em) {
        super(em);
    }
}
