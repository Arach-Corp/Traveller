package br.com.fiap.traveller.dao.impl;

import br.com.fiap.traveller.dao.DAO;
import br.com.fiap.traveller.dao.generic.UsuarioDAO;
import br.com.fiap.traveller.entities.Usuario;

import javax.persistence.EntityManager;

public class UsuarioDAOImpl extends DAO<Usuario, Long> implements UsuarioDAO {
    public UsuarioDAOImpl(EntityManager em) {
        super(em);
    }
}
