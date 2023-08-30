package com.latam.alura.hotel.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "huespedes")
public class Huesped {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private LocalDate fechaDeNacimiento;
	private String nacionalidad;
	private String telefono;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Numero_de_reserva")
	private Reserva reserva;

	public Huesped() {

	}

	public Huesped(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, String telefono,
			Reserva reserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.reserva = reserva;
		

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fecha_nacimiento) {
		this.fechaDeNacimiento = fecha_nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setIdReserva(Reserva idReserva) {
		this.reserva = idReserva;
	}

	public Long getId() {
		return id;
	}

	

}
