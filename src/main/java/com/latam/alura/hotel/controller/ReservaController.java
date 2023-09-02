package com.latam.alura.hotel.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.latam.alura.hotel.dao.ReservaDAO;
import com.latam.alura.hotel.modelo.Reserva;
import com.latam.alura.hotel.utils.JPAutils;

/**
 * Controlador para la gestión de reservas de hotel.
 */
public class ReservaController {
    EntityManager em;
    ReservaDAO reservaDAO;

    /**
     * Constructor de la clase ReservaController.
     * Inicializa el EntityManager y el ReservaDAO.
     */
    public ReservaController() {
        this.em = JPAutils.getEntityManager();
        this.reservaDAO = new ReservaDAO(em);
    }

    /**
     * Guarda una nueva reserva de hotel.
     * 
     * @param fechaDeIngreso Fecha de check-in.
     * @param fechaDeSalida Fecha de check-out.
     * @param valor Valor de la reserva.
     * @param formaDePago Forma de pago de la reserva.
     * @return La reserva creada.
     */
    public Reserva guardar(LocalDate fechaDeIngreso, LocalDate fechaDeSalida, Double valor, String formaDePago) {
        return reservaDAO.guardar(fechaDeIngreso, fechaDeSalida, valor, formaDePago);
    }

    /**
     * Obtiene un modelo de tabla con la lista de reservas.
     * 
     * @return Un DefaultTableModel con los datos de las reservas.
     */
    public DefaultTableModel listar() {
        return reservaDAO.listar();
    }

    /**
     * Modifica una reserva existente.
     * 
     * @param tablareservas JTable que contiene la información de las reservas.
     */
    public void modificar(JTable tablareservas) {
        reservaDAO.modificar(tablareservas);
    }

    /**
     * Elimina una reserva por su ID.
     * 
     * @param id ID de la reserva a eliminar.
     */
    public void eliminar(Long id) {
        reservaDAO.eliminar(id);
    }

    /**
     * Busca reservas por apellido del huésped.
     * 
     * @param apellido Apellido del huésped.
     * @return Un DefaultTableModel con las reservas encontradas.
     */
    public DefaultTableModel buscarPorApellido(String apellido) {
        return reservaDAO.buscarReservasPorApellidoHuesped(apellido);
    }

    /**
     * Busca una reserva por su ID.
     * 
     * @param id ID de la reserva a buscar.
     * @return Un DefaultTableModel con la reserva encontrada.
     */
    public DefaultTableModel buscarPorId(Long id) {
        return reservaDAO.buscarReservaPorId(id);
    }
}
