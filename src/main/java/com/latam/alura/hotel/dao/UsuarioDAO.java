package com.latam.alura.hotel.dao;

import javax.persistence.EntityManager;

import com.latam.alura.hotel.modelo.NivelDeAcceso;
import com.latam.alura.hotel.modelo.Usuario;

public class UsuarioDAO {

	private EntityManager em;

	public UsuarioDAO(EntityManager em) {
		this.em = em;

	}

	public void nuevoUsuario(String nombre, String usuario, String password, NivelDeAcceso nivelDeAcceso) {
		Usuario user = new Usuario(nombre, usuario, password, nivelDeAcceso);
		em.getTransaction().begin();
		this.em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public boolean entrarAsistema(String usuario, String password) {
		String jqpl = "SELECT u FROM Usuario u WHERE u.usuario = :usuario";
		em.getTransaction().begin();

		Usuario user = em.createQuery(jqpl, Usuario.class).setParameter("usuario", usuario).getSingleResult();

		em.close();
		return user != null && user.getContraseña().equals(password);

	}

	public Usuario obtenerUsuario(String usuario, String password) {
		em.getTransaction().begin();
		String jqpl = "SELECT u FROM Usuario u WHERE u.usuario = :usuario";
		Usuario user = em.createQuery(jqpl, Usuario.class).setParameter("usuario", usuario).getSingleResult();
		em.close();

		return user;

	}

	public boolean EsPrimeraVez() {
		String jqpl = "SELECT COUNT(u) FROM Usuario u WHERE u.nivelDeAcceso.id = 1";
		em.getTransaction().begin();
		Long cuenta = em.createQuery(jqpl, Long.class).getSingleResult();
		em.close();
		return cuenta == 0;
		

	}

}
