package br.com.fiap.traveller.dao;

import br.com.fiap.traveller.dao.exceptions.CommitException;
import br.com.fiap.traveller.dao.exceptions.EntityNotFoundException;

import java.util.List;

public interface GenericDAO<E, K>{
    E save(E entity);
    E findById(K id) throws EntityNotFoundException;
    List<E> findAll();
    void deleteById(K id) throws EntityNotFoundException;
    void commit() throws CommitException;
}
