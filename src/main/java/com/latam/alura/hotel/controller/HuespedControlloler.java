package com.latam.alura.hotel.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.latam.alura.hotel.dao.HuespedDAO;
import com.latam.alura.hotel.modelo.Reserva;
import com.latam.alura.hotel.utils.JPAutils;

/**
 * Controlador para la gestión de huéspedes.
 */
public class HuespedControlloler {
    private EntityManager em;
    private HuespedDAO huespedDAO;

    /**
     * Constructor de la clase HuespedController.
     * Inicializa el EntityManager y el HuespedDAO.
     */
    public HuespedControlloler() {
        this.em = JPAutils.getEntityManager();
        this.huespedDAO = new HuespedDAO(em);
    }

    /**
     * Guarda un nuevo huésped en la base de datos.
     * 
     * @param nombre            El nombre del huésped.
     * @param apellido          El apellido del huésped.
     * @param fechaDeNacimiento La fecha de nacimiento del huésped.
     * @param nacionalidad      La nacionalidad del huésped.
     * @param telefono          El teléfono del huésped.
     * @param reserva           La reserva a la que pertenece el huésped.
     */
    public void guardar(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad,
            String telefono, Reserva reserva) {
        huespedDAO.guardar(nombre, apellido, fechaDeNacimiento, nacionalidad, telefono, reserva);
    }

    /**
     * Obtiene un modelo de tabla con la lista de huéspedes.
     * 
     * @return Un modelo de tabla con los datos de los huéspedes.
     */
    public DefaultTableModel listar() {
        return huespedDAO.listar();
    }

    /**
     * Modifica los datos de un huésped en la base de datos.
     * 
     * @param tablaHuespedes La tabla que contiene los datos del huésped a modificar.
     */
    public void modificar(JTable tablaHuespedes) {
        huespedDAO.modificar(tablaHuespedes);
    }

    /**
     * Elimina un huésped de la base de datos.
     * 
     * @param id El ID del huésped a eliminar.
     */
    public void eliminar(Long id) {
        huespedDAO.eliminar(id);
    }

    /**
     * Busca huéspedes por número de reserva o apellido.
     * 
     * @param numeroDeReserva El número de reserva a buscar (puede ser nulo o cero).
     * @param apellido        El apellido del huésped a buscar (puede ser nulo o vacío).
     * @return Un modelo de tabla con los huéspedes que coinciden con los criterios de búsqueda.
     */
    public DefaultTableModel buscarPorNumeroDeReservaOApellido(Long numeroDeReserva, String apellido) {
        return huespedDAO.buscarPorNumeroDeReservaOApellido(numeroDeReserva, apellido);
    }
}
