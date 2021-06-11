package br.com.fiap.traveller.dao.impl;

import br.com.fiap.traveller.dao.DAO;
import br.com.fiap.traveller.dao.generic.CategoriaDAO;
import br.com.fiap.traveller.entities.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDAOImpl extends DAO<Categoria, Long> implements CategoriaDAO {
    public CategoriaDAOImpl(EntityManager em) {
        super(em);
    }
}
