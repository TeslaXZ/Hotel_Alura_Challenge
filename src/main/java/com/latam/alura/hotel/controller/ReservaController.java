package com.latam.alura.hotel.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.latam.alura.hotel.dao.ReservaDAO;
import com.latam.alura.hotel.modelo.Reserva;
import com.latam.alura.hotel.utils.JPAutils;

public class ReservaController {
	EntityManager em;
	ReservaDAO reservaDAO;

	public ReservaController() {
		this.em = JPAutils.getEntityManager();
		this.reservaDAO = new ReservaDAO(em);

	}

	public Reserva guardar(LocalDate fechaDeIngreso, LocalDate fechaDeSalida, Double valor, String formaDePago) {

		return reservaDAO.guardar(fechaDeIngreso, fechaDeSalida, valor, formaDePago);
	}

	public DefaultTableModel listar() {
	
		return reservaDAO.listar();
	}

	public void modificar(JTable tablareservas) {
		reservaDAO.modificar(tablareservas);

	}
	
	
	public void eliminar(Long id) {
		reservaDAO.eliminar(id);
		
	}
	
	public DefaultTableModel buscarPorApellido(String apellido) {
		return reservaDAO.buscarReservasPorApellidoHuesped(apellido);
	}
	
	public DefaultTableModel buscarPorId(Long id) {
		return reservaDAO.buscarReservaPorId(id);
	}

}
