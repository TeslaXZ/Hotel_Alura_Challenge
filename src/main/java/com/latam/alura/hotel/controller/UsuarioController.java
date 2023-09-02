package com.latam.alura.hotel.controller;

import javax.persistence.EntityManager;

import com.latam.alura.hotel.dao.UsuarioDAO;
import com.latam.alura.hotel.modelo.NivelDeAcceso;
import com.latam.alura.hotel.modelo.Usuario;
import com.latam.alura.hotel.utils.JPAutils;

/**
 * Controlador para la gestión de usuarios del sistema.
 */
public class UsuarioController {
    private UsuarioDAO user;
    private EntityManager em;

    /**
     * Constructor de la clase UsuarioController.
     * Inicializa el EntityManager y el UsuarioDAO.
     */
    public UsuarioController() {
        this.em = JPAutils.getEntityManager();
        this.user = new UsuarioDAO(em);
    }

    /**
     * Crea un nuevo usuario en el sistema.
     * 
     * @param nombre         Nombre del usuario.
     * @param usuario        Nombre de usuario.
     * @param password       Contraseña del usuario.
     * @param nivelDeAcceso  Nivel de acceso del usuario.
     */
    public void nuevoUsuario(String nombre, String usuario, String password, NivelDeAcceso nivelDeAcceso) {
        user.nuevoUsuario(nombre, usuario, password, nivelDeAcceso);
    }

    /**
     * Intenta iniciar sesión en el sistema con un nombre de usuario y contraseña.
     * 
     * @param usuario  Nombre de usuario.
     * @param password Contraseña.
     * @return true si la autenticación es exitosa, false en caso contrario.
     */
    public boolean entrarAsistema(String usuario, String password) {
        return user.entrarAsistema(usuario, password);
    }

    /**
     * Obtiene un usuario por su nombre de usuario y contraseña.
     * 
     * @param usuario  Nombre de usuario.
     * @param password Contraseña.
     * @return El usuario encontrado.
     */
    public Usuario obtenerUsuario(String usuario, String password) {
        return user.obtenerUsuario(usuario, password);
    }

    /**
     * Verifica si es la primera vez que se inicia el sistema.
     * 
     * @return true si es la primera vez, false en caso contrario.
     */
    public boolean esPrimeraVez() {
        return user.EsPrimeraVez();
    }
}
