package br.com.fiap.traveller.dao.impl;

import br.com.fiap.traveller.dao.DAO;
import br.com.fiap.traveller.dao.generic.AvaliacaoDAO;
import br.com.fiap.traveller.entities.Avaliacao;
import br.com.fiap.traveller.entities.pk.AvaliacaoPK;

import javax.persistence.EntityManager;

public class AvaliacaoDAOImpl extends DAO<Avaliacao, AvaliacaoPK> implements AvaliacaoDAO {
    public AvaliacaoDAOImpl(EntityManager em) {
        super(em);
    }
}
