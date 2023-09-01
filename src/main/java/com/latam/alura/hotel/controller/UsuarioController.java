package com.latam.alura.hotel.controller;

import javax.persistence.EntityManager;

import com.latam.alura.hotel.dao.UsuarioDAO;
import com.latam.alura.hotel.modelo.NivelDeAcceso;
import com.latam.alura.hotel.modelo.Usuario;
import com.latam.alura.hotel.utils.JPAutils;

public class UsuarioController {
	
	private UsuarioDAO user;
	private EntityManager em;
	
	public UsuarioController() {
		this.em = JPAutils.getEntityManager();
		this.user = new UsuarioDAO(em);
	}
	
	public void nuevoUsuario(String nombre,String usuario, String password,NivelDeAcceso nivelDeAcceso) {
		user.nuevoUsuario(nombre,usuario, password, nivelDeAcceso);
	}
	
	public boolean entrarAsistema(String usuario, String password) {
		return user.entrarAsistema(usuario, password);
		
	}
	
	public Usuario obtenerUsuario(String usuario, String password) {
		return user.obtenerUsuario(usuario, password);
		
	}
	
	public boolean esPrimeraVez() {
		return user.EsPrimeraVez();
	}
	
}
