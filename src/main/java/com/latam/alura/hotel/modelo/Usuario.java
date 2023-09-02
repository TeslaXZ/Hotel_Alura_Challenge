package com.latam.alura.hotel.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa un usuario en el sistema de gestión de reservas de hotel.
 */
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

    /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario() {

    }

    /**
     * Constructor que crea una instancia de Usuario con los datos proporcionados.
     *
     * @param nombre         El nombre del usuario.
     * @param usuario        El nombre de usuario (nombre de inicio de sesión) del usuario.
     * @param contraseña     La contraseña del usuario.
     * @param nivelDeAcceso  El nivel de acceso del usuario.
     */
    public Usuario(String nombre, String usuario, String contraseña, NivelDeAcceso nivelDeAcceso) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = contraseña;
        this.nivelDeAcceso = nivelDeAcceso;
    }

    // Métodos getters y setters

    /**
     * Obtiene el nombre de usuario (nombre de inicio de sesión) del usuario.
     *
     * @return El nombre de usuario del usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario (nombre de inicio de sesión) del usuario.
     *
     * @param usuario El nombre de usuario del usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContraseña() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contraseña La contraseña del usuario.
     */
    public void setContraseña(String contraseña) {
        this.password = contraseña;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre El nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID único del usuario.
     *
     * @return El ID único del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Obtiene el nivel de acceso del usuario.
     *
     * @return El nivel de acceso del usuario.
     */
    public NivelDeAcceso getNivelDeAcceso() {
        return nivelDeAcceso;
    }

    /**
     * Establece el nivel de acceso del usuario.
     *
     * @param nivelDeAcceso El nivel de acceso del usuario.
     */
    public void setNivelDeAcceso(NivelDeAcceso nivelDeAcceso) {
        this.nivelDeAcceso = nivelDeAcceso;
    }
}
