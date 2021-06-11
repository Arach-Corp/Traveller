package br.com.fiap.traveller.dao;


import br.com.fiap.traveller.dao.exceptions.CommitException;
import br.com.fiap.traveller.dao.exceptions.EntityNotFoundException;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class DAO<E, K> implements GenericDAO<E, K> {
    private EntityManager em;
    private Class<E> clazz;


    public DAO(EntityManager em){
        this.em= em;
        this.clazz = ((Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public E save(E entity) {
        return em.merge(entity);
    }

    @Override
    public List<E> findAll() {
        return em.createQuery("FROM " + clazz.getName()).getResultList();
    }

    @Override
    public E findById(K id) throws EntityNotFoundException {
        E entity = em.find(clazz, id);
        if (entity != null) return entity;
        throw new EntityNotFoundException("Nenhum resultado encontrado para o ID: " + id);
    }

    @Override
    public void deleteById(K id) throws EntityNotFoundException {
        em.remove(findById(id));
    }

    @Override
    public void commit() throws CommitException {
        try{
            em.getTransaction().begin();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new CommitException(e.getMessage());
        }
    }
}