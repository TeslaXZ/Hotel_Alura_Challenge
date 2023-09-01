package com.latam.alura.hotel.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@Column(nullable = false, unique = true)
	private String usuario;
	@Column(nullable = false)
	private String password;
	@ManyToOne
	private NivelDeAcceso nivelDeAcceso;


	public Usuario() {
	}

	public Usuario(String nombre, String usuario, String contraseña, NivelDeAcceso nivelDeAcceso) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.password = contraseña;
		this.nivelDeAcceso = nivelDeAcceso;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return password;
	}

	public void setContraseña(String contraseña) {
		this.password = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}
	
	public NivelDeAcceso getNivelDeAcceso() {
		return nivelDeAcceso;
	}

	public void setNivelDeAcceso(NivelDeAcceso nivelDeAcceso) {
		this.nivelDeAcceso = nivelDeAcceso;
	}

}
