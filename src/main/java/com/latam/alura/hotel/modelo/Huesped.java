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

/**
 * Clase que representa a un huésped en el sistema de gestión de reservas de hotel.
 */
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

    /**
     * Constructor por defecto de la clase Huesped.
     */
    public Huesped() {

    }

    /**
     * Constructor que crea una instancia de Huesped con los datos proporcionados.
     *
     * @param nombre            El nombre del huésped.
     * @param apellido          El apellido del huésped.
     * @param fechaDeNacimiento La fecha de nacimiento del huésped.
     * @param nacionalidad      La nacionalidad del huésped.
     * @param telefono          El número de teléfono del huésped.
     * @param reserva           La reserva asociada al huésped.
     */
    public Huesped(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad, String telefono,
                   Reserva reserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.reserva = reserva;
    }

    // Métodos getters y setters

    /**
     * Obtiene el nombre del huésped.
     *
     * @return El nombre del huésped.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del huésped.
     *
     * @param nombre El nombre del huésped.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del huésped.
     *
     * @return El apellido del huésped.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del huésped.
     *
     * @param apellido El apellido del huésped.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene la fecha de nacimiento del huésped.
     *
     * @return La fecha de nacimiento del huésped.
     */
    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del huésped.
     *
     * @param fechaDeNacimiento La fecha de nacimiento del huésped.
     */
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    /**
     * Obtiene la nacionalidad del huésped.
     *
     * @return La nacionalidad del huésped.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Establece la nacionalidad del huésped.
     *
     * @param nacionalidad La nacionalidad del huésped.
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Obtiene el número de teléfono del huésped.
     *
     * @return El número de teléfono del huésped.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del huésped.
     *
     * @param telefono El número de teléfono del huésped.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la reserva asociada al huésped.
     *
     * @return La reserva asociada al huésped.
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * Establece la reserva asociada al huésped.
     *
     * @param reserva La reserva asociada al huésped.
     */
    public void setIdReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    /**
     * Obtiene el ID único del huésped.
     *
     * @return El ID único del huésped.
     */
    public Long getId() {
        return id;
    }
}
