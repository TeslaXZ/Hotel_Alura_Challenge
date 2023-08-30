package com.latam.alura.hotel.dao;

import javax.persistence.EntityManager;

import com.latam.alura.hotel.modelo.Usuario;

public class UsuarioDAO {
	
	private EntityManager em;

	public UsuarioDAO(EntityManager em) {
		this.em = em;

	}
	
	
	public void nuevoUsuario(String nombre,String usuario , String password) {
		Usuario user =  new Usuario(nombre, usuario, password);
		em.getTransaction().begin();
		this.em.persist(user);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public boolean entrarAsistema(String usuario , String password) {
		String jqpl = "SELECT u FROM Usuario u WHERE u.usuario = :usuario";
		Usuario user = em.createQuery(jqpl,Usuario.class).setParameter("usuario", usuario).getSingleResult();
		em.close();
		
		return user != null && user.getContraseña().equals(password);
		
	}

}
