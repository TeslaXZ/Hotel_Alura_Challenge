package com.latam.alura.hotel.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.hotel.dao.NivelDeAccesoDAO;
import com.latam.alura.hotel.modelo.NivelDeAcceso;
import com.latam.alura.hotel.utils.JPAutils;

/**
 * Controlador para la gestión de niveles de acceso.
 */
public class NivelDeAccesoController {
	private NivelDeAccesoDAO nivelDeAccesoDAO;

	/**
	 * Constructor de la clase NivelDeAccesoController. Inicializa el
	 * NivelDeAccesoDAO.
	 */
	public NivelDeAccesoController() {
		EntityManager em = JPAutils.getEntityManager();
		this.nivelDeAccesoDAO = new NivelDeAccesoDAO(em);
	}

	/**
	 * Obtiene una lista de niveles de acceso.
	 * 
	 * @return Una lista de objetos NivelDeAcceso.
	 */
	public List<NivelDeAcceso> ListarNiveles() {
		return nivelDeAccesoDAO.ListarNivelesAcceso();
	}

	/**
	 * Ingresa los niveles de acceso por defecto si es la primera ejecución.
	 */
	public void ingresarNivelesDeAcceso() {
		nivelDeAccesoDAO.ejecutarNamedQuery();
	}
}
