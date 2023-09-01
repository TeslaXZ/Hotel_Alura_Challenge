package com.latam.alura.hotel.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.hotel.dao.NivelDeAccesoDAO;
import com.latam.alura.hotel.modelo.NivelDeAcceso;
import com.latam.alura.hotel.utils.JPAutils;

public class NivelDeAccesoController {
	
	private NivelDeAccesoDAO nivelDeAccesoDAO;
	
	public NivelDeAccesoController() {
		EntityManager em = JPAutils.getEntityManager();
		this.nivelDeAccesoDAO = new NivelDeAccesoDAO(em);
	}
	
	public List<NivelDeAcceso> ListarNiveles(){
		return nivelDeAccesoDAO.ListarNivelesAcceso();
	}
	
	public void ingresarNivelesDeAcceso() {
		nivelDeAccesoDAO.ejecutarNamedQuery();
	}
}
