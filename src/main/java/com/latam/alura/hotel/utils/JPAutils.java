package com.latam.alura.hotel.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase utilitaria para obtener un EntityManager de JPA.
 */
public class JPAutils {
    private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("hotel_alura");

    /**
     * Obtiene un EntityManager para interactuar con la base de datos.
     *
     * @return EntityManager.
     */
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
