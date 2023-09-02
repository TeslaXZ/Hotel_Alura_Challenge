package com.latam.alura.hotel.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa una reserva en el sistema de gestión de reservas de hotel.
 */
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

    /**
     * Constructor por defecto de la clase Reserva.
     */
    public Reserva() {

    }

    /**
     * Constructor que crea una instancia de Reserva con los datos proporcionados.
     *
     * @param fechaDeIngreso La fecha de ingreso asociada a la reserva.
     * @param fechaDeSalida  La fecha de salida asociada a la reserva.
     * @param valor          El valor de la reserva.
     * @param formaDePago    La forma de pago utilizada para la reserva.
     */
    public Reserva(LocalDate fechaDeIngreso, LocalDate fechaDeSalida, Double valor, String formaDePago) {
        this.fechaDeIngreso = fechaDeIngreso;
        this.fechaDeSalida = fechaDeSalida;
        this.valor = valor;
        this.formaDePago = formaDePago;
    }

    // Métodos getters y setters

    /**
     * Obtiene el ID único de la reserva.
     *
     * @return El ID único de la reserva.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID único de la reserva.
     *
     * @param id El ID único de la reserva.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de ingreso asociada a la reserva.
     *
     * @return La fecha de ingreso asociada a la reserva.
     */
    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    /**
     * Establece la fecha de ingreso asociada a la reserva.
     *
     * @param fechaDeIngreso La fecha de ingreso asociada a la reserva.
     */
    public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    /**
     * Obtiene la fecha de salida asociada a la reserva.
     *
     * @return La fecha de salida asociada a la reserva.
     */
    public LocalDate getFechaDeSalida() {
        return fechaDeSalida;
    }

    /**
     * Establece la fecha de salida asociada a la reserva.
     *
     * @param fechaDeSalida La fecha de salida asociada a la reserva.
     */
    public void setFechaDeSalida(LocalDate fechaDeSalida) {
        this.fechaDeSalida = fechaDeSalida;
    }

    /**
     * Obtiene el valor de la reserva.
     *
     * @return El valor de la reserva.
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Establece el valor de la reserva.
     *
     * @param valor El valor de la reserva.
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Obtiene la forma de pago utilizada para la reserva.
     *
     * @return La forma de pago utilizada para la reserva.
     */
    public String getFormaDePago() {
        return formaDePago;
    }

    /**
     * Establece la forma de pago utilizada para la reserva.
     *
     * @param formaDePago La forma de pago utilizada para la reserva.
     */
    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    /**
     * Obtiene la lista de huéspedes asociados a la reserva.
     *
     * @return La lista de huéspedes asociados a la reserva.
     */
    public List<Huesped> getHuespedes() {
        return huespedes;
    }

    /**
     * Establece la lista de huéspedes asociados a la reserva.
     *
     * @param huespedes La lista de huéspedes asociados a la reserva.
     */
    public void setHuespedes(List<Huesped> huespedes) {
        this.huespedes = huespedes;
    }
}
