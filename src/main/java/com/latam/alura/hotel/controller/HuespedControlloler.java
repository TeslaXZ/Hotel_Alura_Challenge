package com.latam.alura.hotel.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.latam.alura.hotel.dao.HuespedDAO;
import com.latam.alura.hotel.modelo.Reserva;
import com.latam.alura.hotel.utils.JPAutils;

public class HuespedControlloler {
	EntityManager em;
	HuespedDAO huespedDAO;

	public HuespedControlloler() {
		this.em = JPAutils.getEntityManager();
		this.huespedDAO = new HuespedDAO(em);

	}

	public void guardar(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad,
			String telefono, Reserva reserva) {
		
		
			huespedDAO.guardar(nombre, apellido, fechaDeNacimiento, nacionalidad, telefono, reserva);

		
		
	}

	public DefaultTableModel listar() {

		return huespedDAO.listar();

	}

	public void modificar(JTable tablaHuespedes) {
		huespedDAO.modificar(tablaHuespedes);

	}

	public void eliminar(Long id) {
		huespedDAO.eliminar(id);
	}
	
	public DefaultTableModel buscarPorNumeroDeReservaOApellido(Long numeroDeReserva, String apellido) {
		return huespedDAO.buscarPorNumeroDeReservaOApellido(numeroDeReserva, apellido);
	}

}
