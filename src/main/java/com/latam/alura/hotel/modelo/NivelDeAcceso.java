package com.latam.alura.hotel.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase que representa el nivel de acceso de un usuario en el sistema de gestión de reservas de hotel.
 */
@Entity
public class NivelDeAcceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rol;

    /**
     * Constructor por defecto de la clase NivelDeAcceso.
     */
    public NivelDeAcceso() {

    }

    /**
     * Constructor que crea una instancia de NivelDeAcceso con el rol proporcionado.
     *
     * @param rol El rol asociado al nivel de acceso.
     */
    public NivelDeAcceso(String rol) {
        this.rol = rol;
    }

    // Métodos getters y setters

    /**
     * Obtiene el rol asociado al nivel de acceso.
     *
     * @return El rol asociado al nivel de acceso.
     */
    public String getRol() {
        return rol;
    }

    /**
     * Establece el rol asociado al nivel de acceso.
     *
     * @param rol El rol asociado al nivel de acceso.
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Obtiene el ID único del nivel de acceso.
     *
     * @return El ID único del nivel de acceso.
     */
    public Long getId() {
        return id;
    }

    /**
     * Devuelve una representación de cadena del nivel de acceso (en este caso, el rol).
     *
     * @return El rol como una representación de cadena.
     */
    @Override
    public String toString() {
        return this.rol;
    }
}
