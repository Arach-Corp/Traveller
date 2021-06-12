package br.com.fiap.traveller.dao.impl;

import br.com.fiap.traveller.dao.DAO;
import br.com.fiap.traveller.dao.generic.UsuarioDAO;
import br.com.fiap.traveller.entities.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioDAOImpl extends DAO<Usuario, Long> implements UsuarioDAO {
    public UsuarioDAOImpl(EntityManager em) {
        super(em);
    }


    @Override
    public Usuario findByEmail(String email) {
        TypedQuery<Usuario> query = getEm().createQuery("From Usuario u where u.email = :email", Usuario.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}
