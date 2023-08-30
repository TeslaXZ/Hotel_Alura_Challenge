package com.latam.alura.hotel.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	@Entity
	@Table(name = "reservas")
	public class Reserva {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private LocalDate fechaDeIngreso;
		private LocalDate fechaDeSalida;
		private Double valor;
		private String formaDePago;
		@OneToMany(mappedBy = "reserva")
	    private List<Huesped> huespedes;
		
		
		public Reserva() {
		}


	public Reserva(LocalDate fechaDeIngreso, LocalDate fechaDeSalida, Double valor, String formaDePago) {
		
		this.fechaDeIngreso = fechaDeIngreso;
		this.fechaDeSalida = fechaDeSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}


	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}


	public LocalDate getFechaDeSalida() {
		return fechaDeSalida;
	}


	public void setFechaDeSalida(LocalDate fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public String getFormaDePago() {
		return formaDePago;
	}


	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	
	
	
	
	
	
	
}
