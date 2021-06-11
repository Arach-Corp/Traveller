package br.com.fiap.traveller.dao.impl;

import br.com.fiap.traveller.dao.DAO;
import br.com.fiap.traveller.dao.generic.DicaDAO;
import br.com.fiap.traveller.entities.Dica;

import javax.persistence.EntityManager;

public class DicaDAOImpl extends DAO<Dica, Long> implements DicaDAO {
    public DicaDAOImpl(EntityManager em) {
        super(em);
    }
}
