package br.com.fiap.traveller.dao.impl;

import br.com.fiap.traveller.dao.DAO;
import br.com.fiap.traveller.dao.generic.PontoTuristicoDAO;
import br.com.fiap.traveller.entities.PontoTuristico;

import javax.persistence.EntityManager;

public class PontoTuristicoDAOImpl extends DAO<PontoTuristico, Long> implements PontoTuristicoDAO {
    public PontoTuristicoDAOImpl(EntityManager em) {
        super(em);
    }
}
