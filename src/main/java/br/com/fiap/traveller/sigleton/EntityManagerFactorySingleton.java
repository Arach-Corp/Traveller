package br.com.fiap.traveller.sigleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private static final String PERSIST_UNIT = "postgres";
    private static EntityManagerFactory factory;

    private EntityManagerFactorySingleton(){
    }

    public static EntityManagerFactory getInstance(){
        if (factory == null){
            factory = Persistence.createEntityManagerFactory(PERSIST_UNIT);
        }
        return factory;
    }

}
