package com.latam.alura.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.hotel.modelo.NivelDeAcceso;

/**
 * Esta clase proporciona métodos para acceder a la base de datos y realizar operaciones relacionadas con los niveles de acceso.
 */
public class NivelDeAccesoDAO {
    
    private EntityManager em;
    
    /**
     * Constructor de la clase NivelDeAccesoDAO.
     * 
     * @param em El EntityManager utilizado para gestionar las operaciones de base de datos.
     */
    public NivelDeAccesoDAO(EntityManager em) {
        this.em = em;
    }
    
    /**
     * Lista todos los niveles de acceso almacenados en la base de datos.
     * 
     * @return Una lista de los niveles de acceso encontrados en la base de datos.
     */
    public List<NivelDeAcceso> ListarNivelesAcceso(){

        em.getTransaction().begin();
        List<NivelDeAcceso> ListaNiveles = em.createQuery("SELECT n FROM NivelDeAcceso as n", NivelDeAcceso.class).getResultList();
        em.close();
        return ListaNiveles;
        
    }
    
    /**
     * Ejecuta una consulta con nombre (NamedQuery) para verificar si es la primera ejecución del programa.
     * Si es la primera ejecución, se crean dos niveles de acceso: "Administrador" y "Empleado".
     */
    public void ejecutarNamedQuery() {
        if(esPrimeraEjecucion()) {
            NivelDeAcceso administrador = new NivelDeAcceso("Administrador");
            NivelDeAcceso empleado = new NivelDeAcceso("Empleado");
            em.persist(administrador);
            em.persist(empleado);
            
            em.getTransaction().commit();
        }
        em.close();
    }
    
    /**
     * Verifica si es la primera ejecución del programa.
     * 
     * @return `true` si es la primera ejecución, `false` en caso contrario.
     */
    private boolean esPrimeraEjecucion() {
        em.getTransaction().begin();
        Long count = em.createQuery("SELECT COUNT(n) FROM NivelDeAcceso n", Long.class)
                     .getSingleResult();
       
        return count == 0;
    }
}
