package com.latam.alura.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.hotel.modelo.NivelDeAcceso;

public class NivelDeAccesoDAO {
	
	private EntityManager em;
	
	public NivelDeAccesoDAO(EntityManager em) {
		this.em = em;
	}
	
	public List<NivelDeAcceso> ListarNivelesAcceso(){

		em.getTransaction().begin();
		List<NivelDeAcceso> ListaNiveles = em.createQuery("SELECT n FROM NivelDeAcceso as n", NivelDeAcceso.class).getResultList();
		em.close();
		return ListaNiveles;
		
	}
	
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
	
	 private boolean esPrimeraEjecucion() {
	        em.getTransaction().begin();
	        Long count = em.createQuery("SELECT COUNT(n) FROM NivelDeAcceso n", Long.class)
	                     .getSingleResult();
	       
	        return count == 0;
	    }

}
